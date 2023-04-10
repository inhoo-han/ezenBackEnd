package servletlink.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		String user_hp = request.getParameter("user_hp");
		String user_email = request.getParameter("user_email");
		String user_address = request.getParameter("user_address");
		
		String data = "<html><body>";
		data += "<h2>😁로그인 하셨습니다😁</h2>";
		data += "<h3>💘아이디 : " + user_id + "</h3>";
		data += "<h3>🧡비밀번호 : " + user_pwd + "</h3>";
		data += "<h3>💛연락처 : " + user_hp + "</h3>";
		data += "<h3>💚이메일 : " + user_email + "</h3>";
		data += "<h3>💙주소 : " + user_address + "</h3>";
		data += "<a href = '/servletlink/sports?user_id=" + user_id + "'>스포츠 중계보기</a>";
		data += "</body></html>";
		out.print(data);
		
	}

}
