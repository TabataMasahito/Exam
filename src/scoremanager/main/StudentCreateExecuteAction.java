package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Student;
import bean.Teacher;
import dao.StudentDao;
import tool.Action;
public class StudentCreateExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		HttpSession session = request.getSession();//セッション
		Teacher teacher = (Teacher)session.getAttribute("teacher");

		School school = new School();
//		school.setCd("oom");//学校コードをセットする
//		school.setName("学校名");//学校名をセットする
		boolean isAttend = true;

		Integer entyear=Integer.parseInt(request.getParameter("ent_year"));
		String no=request.getParameter("no");
		String name=request.getParameter("name");
		String classnum=request.getParameter("class_num");
		Student p=new Student();

		p.setNo(no);
		p.setName(name);
		p.setEntYear(entyear);
		p.setClassNum(classnum);
		p.setAttend(isAttend);
		p.setSchool(((Teacher)session.getAttribute("teacher")).getSchool());



		StudentDao dao=new StudentDao();
		dao.save(p);

		request.getRequestDispatcher("student_create_done.jsp").forward(request, response);
	}

}
