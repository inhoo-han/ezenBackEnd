package servletlink.exdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/show")
public class ShowMember extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Boolean isLogon = false;
		//회원등급 확인하려고 했는데 로그인도 안 했을 때 세션 생성하면 안 되겠죠?
		//getSession(false) : 세션 정보가 있으면 불러오되 세션 정보가 없으면 null값을 돌려준다.
		HttpSession session = request.getSession(false);
		if(session != null) {
			//세션 정보가 있을 때
			isLogon = (Boolean)session.getAttribute("isLogon");
			if(isLogon) {
				//isLogon == true; 로그인 했다.
				String id=(String)session.getAttribute("log_id");
				out.print("<html><body>");
				out.print("<p>" + id + "님은 골드회원입니다. 대단해요🤗🤗");
				out.print("<p>할인권을 이용해서 쇼핑을 즐겨보세요</p>");
				out.print("</body></html>");
			} else {
				response.sendRedirect("logindb.html");
			}
		}else {
			//세션 정보가 없을 때
			//sendRedirect(A): 포워드. 웹 브라우저에 재요청하는 방식.
			response.sendRedirect("logindb.html");
		}
	}

}
