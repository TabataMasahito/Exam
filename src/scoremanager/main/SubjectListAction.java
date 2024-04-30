package scoremanager.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectListAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		HttpSession session = request.getSession();//セッション
		Teacher teacher = (Teacher)session.getAttribute("teacher");

		School school = new School();
//		school.setCd("oom");//学校コードをセットする
//		school.setName("学校名");//学校名をセットする
//
//
//		Teacher teacher = new Teacher();
//		teacher.setId("admin");
//		teacher.setName("大原花子");
//		teacher.setPassword("password");
//		teacher.setSchool(school);


		List<Subject> subject = null;//学生リスト
		SubjectDao sDao = new SubjectDao();//学生Dao
		Map<String, String> errors = new HashMap<>();//エラーメッセージ

		subject = sDao.filter(teacher.getSchool());

		//リクエストに学生リストをセット
		request.setAttribute("subject", subject);
		//JSPへフォワード７
		request.getRequestDispatcher("subject_list.jsp").forward(request, response);
	}

}
