package servletAPI.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second4")
public class SecondDispatch2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name = (String)request.getAttribute("name");
		String address = (String)request.getAttribute("address");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>😊" + name + "님 환영합니다😊</h2>");
		out.println("<h3>dispatch를 이용한 binding 실습중입니다. </h3>");
		out.println("<p>🏠우리집은 " + address + "🏠🐱‍👤</p>");
		out.println("</body></html>");
	}

}
