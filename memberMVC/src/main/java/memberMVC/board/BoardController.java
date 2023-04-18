package memberMVC.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	//변수 선언
	BoardService boardService;
	ArticleVO articleVO;
	
	public void init() throws ServletException {
		//BoardService의 인스턴스객체 생성
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String nextPage = "";
		String action = request.getPathInfo(); //요청(매핑)명을 가져온다.
		System.out.println("요청 매핑 이름 : " + action);
		//getPathInfo요청을 처리하면서 에러가 발생할 수 있다.
		try {
			List<ArticleVO> articleList = new ArrayList<ArticleVO>();
			if (action == null || action.equals("/listArticles.do")) {
				articleList = boardService.listArticles();
				request.setAttribute("articleList", articleList);
				nextPage = "/boardInfo/listArticles.jsp";
			}else if(action.equals("/articleForm.do")) {
				nextPage = "/boardInfo/articleForm.jsp";
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println("요청 처리 중 에러!!");
			e.printStackTrace();
		}
	}
}
