package servlet02.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugu")
public class GuGuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init메서드 출력");
	}

	public void destroy() {
		System.out.println("destroy메서드 출력");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("doGet메서드 호출");
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("doPost메서드 호출");
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int guguNum = Integer.parseInt(request.getParameter("gugu_num"));

		out.print("<html><body>");
		out.print("<h2>* * "+guguNum + "단 * *</h2>");
		for(int i = 1; i < 10; i++) {
			out.print("<p>" + guguNum + " X " + i + " = " + guguNum*i+ "</p>");
		}
		
		out.print("<p>-----------------------------<p>");
		out.print("<p>다른 단을 알아보고 싶다면?🤣🤣🤣<p>");
		out.print("<a href='http://localhost:8090/servlet02/test/gugudan.html'>다른 단 페이지로 이동</a>");
		
		out.print("</body></html>");
	}

}
