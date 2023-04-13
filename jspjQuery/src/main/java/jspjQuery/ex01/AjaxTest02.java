package jspjQuery.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax2")
public class AjaxTest02 extends HttpServlet {
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
		PrintWriter out = response.getWriter();
		//<main>, <book>: 내가 만든 태그이다.
		/*[1번책]*/
		out.print("<main>");
		out.print("<book>");
		out.print("<title>Node.js 프로그래밍</title>");
		out.print("<writer>한빛미디어 [윤인성]</writer>");
		    //이미지를 서버에서 받는다.
		out.print("<image>http://127.0.0.1:8090/jspjQuery/images/node.jpg</image>");
		out.print("");
		out.print("</book>");
		
		/*[2번책]*/
		out.print("<book>");
		out.print("<title>실시간 사용자 경험 프로그래밍</title>");
		out.print("<writer>한빛미디어 [테드로덴]</writer>");
		out.print("<image>http://127.0.0.1:8090/jspjQuery/images/ux.gif</image>");
		out.print("");
		out.print("</book>");
		out.print("</main>");
	}
}
