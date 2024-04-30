package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Subject;


public class SubjectDao extends Dao{

	private String baseSql ="select * from subject where school_cd=? ";

	public Subject get(String cd,School school) throws Exception{
		//学生インスタンスを初期化
		Subject subject = new Subject();
		//データベースへのコネクションを確率
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement statement = null;
		try{
			//プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("select * from subject where cd=?");
			//プリペアードステートメントに学生番号をバインド
			statement.setString(1, cd);
			//プリペアードステートメントを実行
			ResultSet rSet = statement.executeQuery();

			//学校Daoを初期化
			SchoolDao schoolDao = new SchoolDao();

			if(rSet.next()){
				//リザルトリセットが存在する場合
				//学生インスタンスに検索結果をセット
				subject.setCd(rSet.getString("cd"));
				subject.setName(rSet.getString("name"));
				//学生フィールドには学校コードで検索した学校インスタンスをセット
				subject.setSchool(schoolDao.get(rSet.getString("school_cd")));

			}else{
				//リザルトリセットが存在しない場合
				//学生インスタンスにnullをセット
				subject = null;
			}
		} catch(Exception e){
			throw e;
		} finally{
			//プリペアードステートメントを閉じる
			if (statement != null){
				try{
					statement.close();
				} catch (SQLException sqle){
					throw sqle;
				}
			}
			//コネクションを閉じる
			if(connection != null){
				try{
					connection.close();
				} catch (SQLException sqle){
					throw sqle;
				}
			}
		}
		return subject;

	}


	private List<Subject> postFilter(ResultSet rSet,School school)throws Exception{
		//リストを初期化
		List<Subject> list = new ArrayList<>();
		try{
			//リザルトリセットを全権走査
			while(rSet.next()){
				//学生インスタンスを初期化
				Subject subject = new Subject();
				//学生インスタンスに検索結果をセット
				subject.setCd(rSet.getString("cd"));
				subject.setName(rSet.getString("name"));

				//リストに追加
				list.add(subject);
			}
		}catch (SQLException | NullPointerException e){
			e.printStackTrace();
		}
		return list;

	}


	public List<Subject>filter(School school)throws Exception{

		//リストを初期化
		List<Subject> list = new ArrayList<>();
		//コネクションを確率
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement statement = null;
		//リザルトリセット
		ResultSet rSet = null;
		//SQL文の条件
		String order = " order by cd asc";

		//SQL文の在学フラグ
		String conditionIsAttend = "";


		try{
			//プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement(baseSql + conditionIsAttend + order);
			//プリペアードステートメントに学校コードをバインド
			statement.setString(1,school.getCd());
			//プリペアードステートメントを実行
			rSet = statement.executeQuery();
			//リストへの格納処理を実行
			list = postFilter(rSet,school);
		}catch(Exception e){
			throw e;
		}finally{
			//プリペアードステートメントを閉じる
			if (statement != null){
				try{
					statement.close();
				}catch (SQLException sqle){
					throw sqle;
				}
			}
			//コネクションを閉じる
			if(connection != null){
				try{
					connection.close();
				}catch(SQLException sqle){
					throw sqle;
				}
			}
		}
		return list;
	}
}
//	public boolean save(Subject subject)throws Exception{
//		//コネクションを確立
//		Connection connection = getConnection();
//		//プリペアードステートメント
//		PreparedStatement statement = null;
//		//実行件数
//		int count = 0;
//
//		try{
//			//データベースから学生を取得
//			Subject old = get(subject.getCd());
//			if (old==null){
//				//学生が存在しなかった場合
//				//プリペアードステートメントにINSERT文をセット
//				statement = connection.prepareStatement("insert into student(no,name,ent_year,class_num,is_attend,school_cd)values(?,?,?,?,?,?)");
//				//プリアドステートメントに値をバインド
//				statement.setString(1,student.getNo());
//				statement.setString(2,student.getName());
//				statement.setInt(3, student.getEntYear());
//				statement.setString(4, student.getClassNum());
//				statement.setBoolean(5, student.isAttend());
//				statement.setString(6, student.getSchool().getCd());
//			}else{
//				//学生が存在した場合
//				//プライベートステートメントにUPDATE文をセット
//				statement = connection.prepareStatement("update student set name=?,ent_year=?,class_num=?,is_attend=? where no=?");
//				//プライベートステートメントに値をバインド
//				statement.setString(1, student.getName());
//				statement.setInt(2, student.getEntYear());
//				statement.setString(3, student.getClassNum());
//				statement.setBoolean(4, student.isAttend());
//				statement.setString(5, student.getNo());
//
//			}
//			//プリペアードステートメントを実行
//			count = statement.executeUpdate();
//	}catch (Exception e){
//		throw e;
//	}finally{
//		//プリペアードステートメントを閉じる
//		if(statement != null){
//			try{
//				statement.close();
//			}catch(SQLException sqle){
//				throw sqle;
//			}
//		}
//		//コネクションを閉じる
//		if(connection != null){
//			try{
//				connection.close();
//			}catch (SQLException sqle){
//				throw sqle;
//			}
//		}
//	}
//	if(count > 0){
//		//実行件数が1以上ある場合
//		return true;
//	}else{
//		//実行件数が0の場合
//		return false;
//	}
//
//

//
//
//
//
