package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.GetMutterListLogic;
import model.Mutter;
import model.PostMutterLogic;
import model.User;


@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//つぶやきリストを取得して、リクエストスコープに保存
		GetMutterListLogic getMutterListLogic =
				new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();
		request.setAttribute("mutterList", mutterList);
	
		//ログインしているか確認するためセッションスコープから
		//ユーザー情報を取得
		 //例　(2)sessionスコープのデータを取得
         // 　　HttpSession session = req.getSession();
         // 　　String id = (String)session.getAttribute("id");
		 //以下は、Userという型のloginUserという情報を取得している
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		
		if(loginUser == null) { //もしログインしていない場合は
			response.sendRedirect("/docotsubu/index.jsp"); //リダイレクトでログイン入力画面へ
		}else { //ログイン済みだった場合
			RequestDispatcher dt =
					request.getRequestDispatcher("/WEB-INF/jsp/main.jsp"); //フォワード
			dt.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//リクエストパラメーター（ユーザーが入力した情報）の取得
		//つぶやきである"text"をここでは取得している
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		
		//つぶやきがnullではないか、０文字じゃないかをチェックする
		if(text != null && text.length() != 0) {
			//セッションスコープに保存されたユーザー情報を取得
			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");
			
			//つぶやきをつぶやきリストに追加
			Mutter mutter = new Mutter(loginUser.getName(), text);
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.execute(mutter);
		}else {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "つぶやきが入力されていません");
		}
		//つぶやきリストを取得して、リクエストスコープに保存
		GetMutterListLogic getMutterListLogic =
				new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();
		request.setAttribute("mutterList", mutterList);
		
		//メイン画面にフォワード
		RequestDispatcher dt =
				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dt.forward(request, response);

	}

}
