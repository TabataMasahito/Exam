package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import tool.Action;

public class TestListSubjectExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		HttpSession session = request.getSession();//セッション
		Teacher teacher = (Teacher)session.getAttribute("user");
		
		String cd=request.getParameter("cd");
		String name=request.getParameter("name");

	}


}		