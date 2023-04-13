package jspjQuery.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax1")
public class AjaxTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//rmsg: receive message; 받은 메세지
		String rmsg = (String)request.getParameter("jq");
		System.out.println("💌 받은 내용 : " + rmsg );
		PrintWriter out = response.getWriter();
		out.print("<p>안녕하세요, 서버입니다.</p>");
		out.print("<p>Ajax공부 열심히 하세용</p>");
		out.print("<p></p>");
		out.print("<p>😁안녕히 가세용😁</p>");
	}
}
