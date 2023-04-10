package servletAPI2.ex02.important;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//           ↓여기변경. 가상의 확장자를 사용
//@WebServlet("/*")
public class TestServlet4 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//[get]
		//getContextPath(): 서블릿 컨텍스트(내가 만든 프로젝트-ex.TestServlet1-) 이름을 가져온다.
		String context = request.getContextPath();
		//getRequestURL(): 전체 URL을 가져온다.
		String url = request.getRequestURL().toString();
		//getServletPath(): 서블릿 매핑이름을 가져온다. (ex./first/test)
		String mapping = request.getServletPath();
		//getRequestURI(): URI를 가져온다. (URI? Uniform Resource Identifier. 포트번호 제외하고 그 뒤 내용)
		String uri = request.getRequestURI();
		
		//[출력]
		out.println("<html>");
		out.println("<head>");
		//                         ↓여기변경
		out.println("<title>URL 패턴④</title>");
		out.println("</head>");
		//                              ↓여기변경
		out.println("<body bgcolor='lightcyan'>");
		out.println("<p>-----------------------------------------------------------------------</p>");
		//                          ↓여기변경
		out.println("<h2>TestServlet4입니다.</h2>");
		out.println("<p>💛컨텍스트명 : " + context + "</p>");
		out.println("<p>💛전체경로 : " + url + "</p>");
		out.println("<p>💛매핑명 : " + mapping + "</p>");
		out.println("<p>💛URI명 : " + uri + "</p>");
		out.println("<p>💛URL명 : " + url + "</p>");
		out.println("<p>-----------------------------------------------------------------------</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
