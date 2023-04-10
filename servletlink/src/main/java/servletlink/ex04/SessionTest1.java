package servletlink.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session2")
public class SessionTest1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//getSession(): 세션이 없으면 새롭게 생성. 있으면 그 세션을 가져오는 메서드
		HttpSession session = request.getSession();
		out.print("세션 아이디 : " + session.getId() + "<br>");
		out.print("최초 세션 생성 시간 : " + new Date(session.getCreationTime()) + "<br>");
		out.print("최초 세션 접근 시간 : " + new Date(session.getLastAccessedTime()) + "<br>");
		//세션 유효시간 전에 유효시간을 설정할 수 있다.
//		session.setMaxInactiveInterval(60);
		out.print("세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br>");
		if(session.isNew()) {
			out.print("😎 새 세션이 만들어졌습니다.");
		}else {
			out.print("😊 이미 세션이 만들어졌습니다.");
		}
		//세션 객체를 강제로 삭제
		session.invalidate();
	}

}
