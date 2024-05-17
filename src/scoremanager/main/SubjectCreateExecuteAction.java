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

public class SubjectCreateExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ローカル変数の宣言 1
		//HttpSession session = req.getSession();//セッション
		HttpSession session = request.getSession();//セッション
		Teacher teacher = (Teacher)session.getAttribute("user");

		SubjectDao sDao = new SubjectDao();
		String cd ="";
		String name = "";
		Subject subject = null;

		Map<String, String> errors = new HashMap<>();// エラーメッセージ



		//リクエストパラメータ―の取得 2
		cd = request.getParameter("cd");
		name = request.getParameter("name");


		//DBからデータ取得 3
		subject = sDao.get(cd,teacher.getSchool());

		if (cd.length() != 3){
			errors.put("cd", "科目コードは3文字で入力してください");
		}
			else if(subject == null) {

				subject = new Subject();

				subject.setSchool(teacher.getSchool());
				subject.setCd(cd);
				subject.setName(name);

				sDao.save(subject);
			} else {

				errors.put("cd", "科目コードが重複しています");
			}



		//JSPへフォワード 7


		if(!errors.isEmpty()){
			// リクエスト属性をセット
			request.setAttribute("errors", errors);
			request.setAttribute("cd", cd);
			request.setAttribute("name", name);
			request.getRequestDispatcher("subject_create.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("subject_create_done.jsp").forward(request, response);
	}
}