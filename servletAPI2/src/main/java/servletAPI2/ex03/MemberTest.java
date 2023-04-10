package servletAPI2.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class MemberTest extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		String user_name = request.getParameter("user_name");
		
		out.print("<html><body>");
		out.print("<h2>Member</h2>");
		out.print("<p>✔아이디 : " + user_id + "</p>");
		out.print("<p>✔비밀번호 : " + user_pwd + "</p>");
		out.print("<p>" + user_name + "님 회원가입을 축하합니다.🤗🤗</p>");
		out.print("</body></html>");
	}
}
