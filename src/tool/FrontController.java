package tool;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
*Servlet implementation class FrontController
*/
@WebServlet("FrontContcoller")
public class FrontController extends HttpServlet{
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpSevletResponse response)
	 *
	 */
	protected void deGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		//TODO Auto-genrated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
		/**
	     * @see HttpServlet#doPostttpServletRequest request, HttpSevletResponse response)
		 */
	protected void dePost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		//TODO Auto-genrated method stub
		doGet(request,response);
	}


	@WebServlet(urlPatterns = {"*.action"})
	public class FrontContcoller extends HttpServlet{

		@Override
		protected void deGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			try{
				//パスを取得
				String path = request.getServletPath().substring(1);
				//ファイル名を取得しクラス名に変換
				String name = path.replace("a", "A").replace('/', '.');

				System.out.println("★ servlet path -> " + request.getServletPath());
				System.out.println("★ class name -> " + name);
				//アクションクラスのインスタンスを返却
				Action action = (Action) Class.forName(name).getDeclaredConstructor().newInstance();

				//遷移先URLを取得
				action.execute(request, response);
				//String url = acrion.excute(request, response);
				//request.getRequestDispatcher(url).forward(request,respnse)
			}catch (Exception e){
				e.printStackTrace();
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		}
		@Override
		protected void doPst(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			doGet(request,response);
		}
	}
}


