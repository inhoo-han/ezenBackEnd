package servlet02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}

	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String user_id = request.getParameter("user_id"); //getParameter로 받을 내용 = input태그의 name // 정보 전달하는 변수 역할
		String user_pw = request.getParameter("user_pw");

		PrintWriter pwOut = response.getWriter();
		String data = "<html>";
		data += "<body>";
		data += "<h2>로그인 정보</h2>";
		data += "<p> 아이디 : " + user_id + "</p>";
		data += "<p> 비밀번호 : " + user_pw + "</p>";
		data += "</body>";
		data += "</html>";
		pwOut.print(data);
	}
}
