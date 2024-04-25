package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Teacher;

public class TeacherDao extends Dao {


	public Teacher get(String no) throws Exception{
		//学生インスタンスを初期化
		Teacher teacher = new Teacher();
		//データベースへのコネクションを確率
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement statement = null;
		try{
			//プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("select * from teacher where id=?");
			//プリペアードステートメントに学生番号をバインド
			statement.setString(1, no);
			//プリペアードステートメントを実行
			ResultSet rSet = statement.executeQuery();

			//学校Daoを初期化
			SchoolDao schoolDao = new SchoolDao();

			if(rSet.next()){
				//リザルトリセットが存在する場合
				//学生インスタンスに検索結果をセット
				teacher.setId(rSet.getString("id"));
				teacher.setName(rSet.getString("name"));
				teacher.setPassword(rSet.getString("password"));
				//学生フィールドには学校コードで検索した学校インスタンスをセット
				teacher.setSchool(schoolDao.get(rSet.getString("school_cd")));
			}else{
				//リザルトリセットが存在しない場合
				//学生インスタンスにnullをセット
				teacher = null;
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
		return teacher;

	}


	public Teacher search(String id, String password)
		throws Exception {
		Teacher teacher=null;

		Connection con=getConnection();


		PreparedStatement st;
		st=con.prepareStatement(
			"select * from teacher where id=? and password=?");
		st.setString(1, id);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			teacher=new Teacher();
			teacher.setId(rs.getString("id"));
			teacher.setName(rs.getString("name"));
			teacher.setPassword(rs.getString("password"));
		}

		st.close();
		con.close();
		return teacher;
	}
}
