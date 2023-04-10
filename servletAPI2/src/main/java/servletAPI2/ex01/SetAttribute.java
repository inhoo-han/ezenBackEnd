package servletAPI2.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/set")
public class SetAttribute extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//ctx:context, Msg:Message, ses:session, req:request
		String ctxMsg = "context에 바인딩됩니다.";
		String sesMsg = "session에 바인딩됩니다.";
		String reqMsg = "request에 바인딩됩니다.";
		
		//[1]애플리케이션 스코프
		ServletContext ctx = getServletContext();
		//[2]세션 스코프
		HttpSession session = request.getSession();
		
		ctx.setAttribute("context", ctxMsg);
		session.setAttribute("session", sesMsg);
		request.setAttribute("request", reqMsg);
	}
}
