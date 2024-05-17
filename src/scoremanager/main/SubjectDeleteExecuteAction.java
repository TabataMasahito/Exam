package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;
public class SubjectDeleteExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		HttpSession session = request.getSession();//セッション
		Teacher teacher = (Teacher)session.getAttribute("user");



		String cd=request.getParameter("cd");

		Subject p=new Subject();
//		System.out.println("★ cd" + cd);

		p.setCd(cd);



		SubjectDao dao=new SubjectDao();
		dao.delete(p);


		request.getRequestDispatcher("subject_delete_done.jsp").forward(request, response);
	}

}
