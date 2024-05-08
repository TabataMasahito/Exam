package scoremanager.main;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectDeleteAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		HttpSession session = request.getSession();//セッション
		Teacher teacher = (Teacher)session.getAttribute("teacher");


		Map<String, String> errors = new HashMap<>();//エラーメッセージ




		String cd=request.getParameter("cd");

		SubjectDao dao=new SubjectDao();

		String name=dao.get(cd,teacher.getSchool()).getName();



		request.setAttribute("cd", cd);
		request.setAttribute("name", name);


		//JSPへフォワード７
		request.getRequestDispatcher("subject_delete.jsp").forward(request, response);
	}

}
