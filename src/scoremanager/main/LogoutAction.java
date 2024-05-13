package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class LogoutAction extends Action {
	public void execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		//セッション情報を確認する
		HttpSession session=request.getSession();

		//セッション情報があるかどうかを確認する
		if (session.getAttribute("user")!=null) {
			session.removeAttribute("user");

			request.getRequestDispatcher("logout.jsp").forward(request, response);
		}

}
	}