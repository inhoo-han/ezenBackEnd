package servletAPI.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstRedirect2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//많은 데이터를 바인딩 방식으로 처리
		request.setAttribute("name", "inhoo");
		request.setAttribute("name", "sora");
		request.setAttribute("name", "minseon");
		//매핑이름으로 데이터 전송
		response.sendRedirect("second");
	}

}
