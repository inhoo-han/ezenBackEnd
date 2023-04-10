package servletlink.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login4")
public class SessionTest4 extends HttpServlet {

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
		HttpSession session = request.getSession();
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		if(session.isNew()) {
			if(user_id != null) {
				//setAttribute : 세션에 값을 할당해 줌 ("이름", 클라이언트가 입력한 값);
				session.setAttribute("user_id", user_id);
				//쿠키 차단한 상태로도 읽ㅇㅓ라. 세션쿠키가 아닌 String url변수에 저장한다.
				String url = response.encodeURL("login4");
				//해당 페이지를 새로고침 함. 세션을 만들었기 때문에 세션 있음으로 넘어감.
				out.print("<a href=" + url + ">로그인 상태 확인</a>");
			}else {
				out.print("<a href='login2.html>다시 로그인하세요(1번)</a>");
			}
		}else {
			//getAttribute("가져올 속성 이름") : 속성을 가져옴
			user_id = (String)session.getAttribute("user_id");
			if(user_id != null && user_id.length() != 0) {
				out.print("안녕하세요 " + user_id + "님의 방문을 환영합니다.🤗🤗");
			}else {
				//getAttribute로 가져온 값이 없을 때
				out.print("<a href='login2.html'>다시 로그인하세요(2번)</a>");
				session.invalidate();
			}
		}
	}
}
