package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;
public class StudentDao extends Dao{

	private String baseSql;

	public Student get(String no) throws Exception{

	}
	private List<Student> postFilter(ResultSet rSer,School school) throws Exception{

	}

	public List<Student> filter(School school, int entYear,String classNum,boolean isAttend) throws Exception{

	}
	public List<Student> fillter(School school, int entYear,boolean isAttend) throws Exception{

	}

	public List<Student> filter(School school,boolean isAttend) throws Exception{
	}

	public boolean save(Student student)throws Exception{
	}

	private String baseSql1 ="select * from student where school_cd=?";


	private List<Student>posFilter(ResultSet rSet,School school)throws Exception{
		//リストを初期化
		List<Student> list = new ArrayList<>();
		try{
			//リザルトリセットを全権走査
			while(rSet.next()){
				//学生インスタンスを初期化
				Student student = new Student();
				//学生インスタンスに検索結果をセット
				student.setNo(rSet.getString("no"));
				student.setName(rSet.getString("name"));
				student.setEntYear(rSet.getInt("entYear"));
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
	public List<Student> filter(School school,int entYear, String classNum, boolean isAttend)throws Exception{
		//リストを初期化
		List<Student>list = new ArrayList<>();
		//コネクションを確率
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement statement = null;
		//リザルトセット
		ResultSet rSet = null;
		//SQL文の条件
		String condition = "and ent_year=? and class_num=?";
		//SQL文のソート

	}

}