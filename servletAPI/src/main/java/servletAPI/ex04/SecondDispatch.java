package servletAPI.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/second4")
public class SecondDispatch extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>😊" + name + "님 환영합니다😊.</h2>");
		out.println("<h3>dispatch를 이용한 forward 실습중입니다. </h3>");
		out.println("<p>out.print<b>ln</b>일 때 소스보기</p>");
		out.println("</body></html>");
	}

}
