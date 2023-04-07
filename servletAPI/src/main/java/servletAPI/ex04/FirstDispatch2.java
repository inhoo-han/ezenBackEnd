package servletAPI.ex04;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first4")
public class FirstDispatch2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//↓ 여기 변경
		request.setAttribute("name", "inhoo");
		request.setAttribute("address", "파주시 소리천로");
		//                                                               ↓ 여기 변경
		RequestDispatcher dispatcher = request.getRequestDispatcher("second4");
		dispatcher.forward(request, response);
	}

}
