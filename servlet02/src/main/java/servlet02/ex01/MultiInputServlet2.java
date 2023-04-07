package servlet02.ex01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MultiInputServlet
 */
@WebServlet("/input2")
public class MultiInputServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}

	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Enumeration enu=request.getParameterNames();
		while(enu.hasMoreElements()) {
			//각 요소에 대한 내용이 name에 담김. user_id, user_pw
			String name = (String)enu.nextElement();
			//name에 담긴 user_id의 값(values)이 배열에 저장됨. 
			String[] values=request.getParameterValues(name);
			for(String val : values) {
				System.out.println("매개변수 이름 : " + name + ", 값 : " + val );
			}
		}
	}

}
