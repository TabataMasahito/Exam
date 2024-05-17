//package scoremanager.main;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import bean.School;
//import bean.Subject;
//import bean.Teacher;
//import bean.Test;
//import dao.SubjectDao;
//import dao.TestDao;
//import tool.Action;
//
//public class TestRegistExecuteAction extends Action {
//
//	@Override
//	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
//
//		HttpSession session = req.getSession();
//		Teacher teacher = (Teacher)session.getAttribute("user");
//		TestDao testDao = new TestDao();
//		// 変数を用意
//		String entYearStr = "";  // 入力された入学年度
//		int entYear = 0;
//		String classNum = "";  // 入力されたクラス番号
//		School school = teacher.getSchool();
//		String countStr = "";  // 入力されたテストの回数
//		int count = 0;
//		SubjectDao subjectDao = new SubjectDao();
//		TestDao tDao = new TestDao();
//		String subjectCd;
//
//		// リクエストパラメーターの取得
//		entYearStr = req.getParameter("ent_year");
//		classNum = req.getParameter("class_num");
//		subjectCd = req.getParameter("subject_cd");
//		countStr = req.getParameter("count");
//		Subject subject = subjectDao.get(subjectCd, school);
//
//		if (entYearStr != null) {
//			entYear = Integer.parseInt(entYearStr);
//		}
//
//		if (countStr != null) {
//			count = Integer.parseInt(countStr);
//		}
//
//		List<Test> tests = testDao.filter(entYear, classNum, subject, count, school);
//
//		for (Test t: tests) {
//			int point = Integer.parseInt(req.getParameter("point_" + t.getStudent().getNo()));
//			// 入力値のチェック
//			if (point >= 0 && point <= 100) {
//					t.setClassNum(classNum);
//					t.setNo(t.getNo());
//					t.setPoint(point);
//					t.setSchool(school);
//					t.setStudent(t.getStudent());
//					t.setSubject(subject);
//				} else {
//				req.getRequestDispatcher("test_regist.jsp");
//			}
//			tDao.save(tests);
//			req.getRequestDispatcher("test_regist_done.jsp").forward(req, res);
//		}
//	}
//}
