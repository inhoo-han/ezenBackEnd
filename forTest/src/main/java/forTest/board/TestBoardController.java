package forTest.board;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.UploadContext;
import org.apache.commons.io.FileUtils;

@WebServlet("/testboard/*")
public class TestBoardController extends HttpServlet {
	
	BoardMgr boardMgr;
	BoardBean boardBean;
	
	public void init(ServletConfig config) throws ServletException {
		boardMgr = new BoardMgr();
		boardBean = new BoardBean();
		System.out.println("😊TestBoardController-init 호출😊");
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
		PrintWriter out; 
		HttpSession session; 
		String action = request.getPathInfo(); //요청(매핑)명을 가져온다.
		System.out.println("요청 매핑 이름 : " + action);	
		
		try {
			List<BoardBean> boardList = new ArrayList<BoardBean>();
			//기본페이지
			if(action == null || action.equals("/list.do")) {
				boardList = boardMgr.listOfBoard();
				request.setAttribute("boardList", boardList);
				nextPage = "/board/list.jsp";
			}
			//글쓰기 페이지
			else if(action.equals("/post.do")) {
				String name = request.getParameter("name");
				String pass = request.getParameter("pass");
				String subject = request.getParameter("subject");
				String content = request.getParameter("content");
				
				boardBean.setName(name);
				boardBean.setPass(pass);
				boardBean.setSubject(subject);
				boardBean.setContent(content);
				
				out = response.getWriter();
				out.print("alert('🤗새 글이 추가되었습니다🤗');");
				out.print("location.href='" + request.getContextPath() + "/testboard/list.do';");
				out.print("</script>");
			}
			//게시물 클릭시
			else if(action.equals("/read.do")) {
				String num = request.getParameter("num");
				boardBean = boardMgr.viewOfBoard(Integer.parseInt(num));
				request.setAttribute("article", boardBean);
				nextPage = "/board/read.jsp";
			}
			//삭제버튼 클릭시
			else if(action.equals("/remove.do")) {
				
				out = response.getWriter();
				out.print("alert('🤗게시물이 삭제되었습니다.🤗');");
				out.print("location.href='" + request.getContextPath() + "/testboard/list.do';");
				out.print("</script>");
				
				int num = Integer.parseInt(request.getParameter("num"));
				boardMgr.delMember(num);
				nextPage = "/testboard/list.do";
			}
			//게시물 수정반영하기 버튼 클릭시(원글만. 댓글포함X)
			else if(action.equals("/modArticle.do")) {
				int num = Integer.parseInt(request.getParameter("num"));
				String subject = request.getParameter("subject");
				String content = request.getParameter("content");
				
				boardBean.setNum(num);
				boardBean.setName("name");
				boardBean.setSubject(subject);
				boardBean.setContent(content);
//				boardMgr.mod(boardBean);
				
				out = response.getWriter();
				out.print("<script>");
				out.print("alert('🤗글 수정이 완료되었습니다🤗');");
				out.print("</script>");
				return;
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println("☹TestBoardController - 요청 처리 중 에러 발생☹");
			e.printStackTrace();
		}
	}
}
