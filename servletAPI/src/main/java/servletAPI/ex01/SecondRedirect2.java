package servletAPI.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondRedirect2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//전송시 값을 객체형태로 보내므로 String타입으로 형변환 필요하다.
		String name = (String)request.getAttribute("name");
		out.print("<html><body>");
		out.print("<h2>💗👀 " + name + "님 환영합니다. 👀💗</h2>");
		out.print("</body></html>");
	}

}
