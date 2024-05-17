																package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import tool.Action;

public class TestListAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession();//セッション

		Teacher teacher = (Teacher)session.getAttribute("user");

//		//ローカル変数の宣言 1
//		//HttpSession session = req.getSession(true);// セッションを取得
//		ClassNumDao cNumDao = new ClassNumDao();// クラス番号Daoを初期化
//		SubjectDao subDao = new SubjectDao();
//		//Teacher teacher = (Teacher) session.getAttribute("user");// ログインユーザーを取得
//		LocalDate todaysDate = LocalDate.now();// LcalDateインスタンスを取得
//		int year = todaysDate.getYear();// 現在の年を取得
//		List<Integer> entYearSet = new ArrayList<>();//入学年度のリストを初期化
//
//		//リクエストパラメータ―の取得 2
//		//なし
//
//		//DBからデータ取得 3
//		List<String> list1 = cNumDao.filter(teacher.getSchool());// ログインユーザーの学校コードをもとにクラス番号の一覧を取得
//		List<String> value = subDao.filter_name(teacher.getSchool());
//		List<String> key = subDao.filter_cd(teacher.getSchool());
//		Map<String,String> map = IntStream.range(0, key.size())
//				.boxed()
//				.collect(Collectors.toMap(key::get, value::get));
//
//		//ビジネスロジック 4
//		for (int i = year - 10; i < year + 1; i++) {
//			entYearSet.add(i);
//		}// 現在を起点に前後10年をリストに追加
//
//		//DBへデータ保存 5
//		//なし
//
//		//レスポンス値をセット 6
//		req.setAttribute("class_num_set", list1);//クラス番号のlistをセット
//		req.setAttribute("subject_set", map);
//		req.setAttribute("ent_year_set", entYearSet);//入学年度のlistをセット

		//JSPへフォワード 7
		req.getRequestDispatcher("test_list_student.jsp").forward(req, res);
	}
}