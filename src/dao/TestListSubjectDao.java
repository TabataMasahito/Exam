package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.TestListSubject;

public class TestListSubjectDao extends Dao{

	private String baseSql ="select * from test where school_cd=? ";

	private List<TestListSubject>postFilter(ResultSet rSet)throws Exception{
		//リストを初期化
		List<TestListSubject> list = new ArrayList<>();
		try{
			//リザルトリセットを全権走査
			while(rSet.next()){
				//学生インスタンスを初期化
				Student student = new Student();
				//学生インスタンスに検索結果をセット
				student.setNo(rSet.getString("no"));
				student.setName(rSet.getString("name"));
				student.setEntYear(rSet.getInt("ent_Year"));
				student.setClassNum(rSet.getString("class_num"));
				student.setAttend(rSet.getBoolean("is_attend"));
				student.setSchool(school);
				//リストに追加
				list.add(student);
			}
		}catch (SQLException | NullPointerException e){
			e.printStackTrace();
		}
		return list;
	}

	public List<TestListSubject> filter(int entYear, String classNum,Subject subject,School school)throws Exception{
		//リストを初期化
		List<TestListSubject>list = new ArrayList<>();
		//コネクションを確率
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement statement = null;
		//リザルトセット
		ResultSet rSet = null;
		//SQL文の条件
		String condition = "and ent_year=? and class_num=?";
		//SQL文のソート
		String order = " order by no asc";

		//SQL文の在学フラグ条件
		String conditionIsAttend = "";
		//在学フラグがtrueの場合
		if(isAttend){
			conditionIsAttend = "and is_attend=true";
		}
		try{
			//プリペアードステートメントにSQL文をセット
			statement =  connection.prepareStatement(baseSql + condition + conditionIsAttend + order);
			//プリペアードステートメントに学校コードをバインド
			statement.setString(1,school.getCd());
			//プリペアードステートメントに入学年度をバインド
			statement.setInt(2, entYear);
			//プリペアードステートメントにクラス番号をバインド
			statement.setString(3, classNum);
			//プライベートステートメントを実行
			rSet = statement.executeQuery();

			//リストへの格納処理を実行
			list = postFilter(rSet);
		} catch (Exception e){
			throw e;
		}finally{
			//プリペアードステートメントを閉じる
			if(statement!= null){
				try{
					statement.close();
				}catch(SQLException sqle){
					throw sqle;
				}
			}
			//コネクションを閉じる
			if(connection != null){
				try{
					connection.close();
				}catch (SQLException sqle){
					throw sqle;
				}
			}
		}
		return list;
	}
}