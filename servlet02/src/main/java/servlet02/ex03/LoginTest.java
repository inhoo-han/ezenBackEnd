package servlet02.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginTest")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init메서드 호출");
	}

	public void destroy() {
		System.out.println("destroy메서드 호출");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet메서드 호출");
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost메서드 호출");
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("doHandle메서드 호출");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		if(id != null && id.length() != 0) {
			if(id.equals("admin")) {
				out.print("<html><body>");
				out.print("<p>관리자로 로그인 하셨습니다.<p>");
				out.print("<input type='button' value='상품정보 수정하기'>");
				out.print("<input type='button' value='상품정보 삭제하기'>");
				out.print("</body></html>");
			}
		} else {
			out.print("<html><body>");
			out.print("<p>아이디를 입력해주세요. 제발~~🤣🤣🤣<p>");
			out.print("<a href='http://localhost:8090/servlet02/test/login.html'>로그인 창으로 이동</a>");
			out.print("</body></html>");
		}
	}
}
