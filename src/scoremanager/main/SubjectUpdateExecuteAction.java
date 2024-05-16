package scoremanager.main;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;
public class SubjectUpdateExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		HttpSession session = request.getSession();//セッション
		Teacher teacher = (Teacher)session.getAttribute("user");
		Map<String, String> errors = new HashMap<>();// エラーメッセージ


		String cd=request.getParameter("cd");
		String name=request.getParameter("name");






		Subject p=new Subject();


		p.setCd(cd);
		p.setName(name);



		SubjectDao dao=new SubjectDao();
		Subject subject = null;//学生
		subject = dao.get(cd, teacher.getSchool());

		if (subject == null) {
			dao.save(p);
		}
		else{
			errors.put("cd", "科目が存在していません");
	}

		request.getRequestDispatcher("subject_update_done.jsp").forward(request, response);
	}

}
