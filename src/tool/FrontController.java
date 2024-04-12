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
}