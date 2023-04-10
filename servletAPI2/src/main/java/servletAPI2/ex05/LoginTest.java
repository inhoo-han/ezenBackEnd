package servletAPI2.ex05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//                 ↓여기 변경
@WebServlet("/login2")
public class LoginTest extends HttpServlet {
	ServletContext context = null;
	List user_list = new ArrayList<>();			//동적.....배열.....누구시더라.....

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//↓여기 변경
		context = getServletContext();
		
		HttpSession session = request.getSession();
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		
		LoginImpl loginUser = new LoginImpl(user_id, user_pwd);
		if(session.isNew()) {
			session.setAttribute("loginUser", loginUser);
			//↓여기 변경
			user_list.add(user_id);
			context.setAttribute("user_list", user_list);
		}
		out.print("<html>");
		out.print("<body bgcolor='lightyellow'>");
		out.print("<h2>😝메롱😝</h2>");
		out.print("<p><b>[System]</b> 아이디 : " + loginUser.user_id + "님이 접속하셨습니다. </p>");
		out.print("<p><b>[System]</b> 총 접속자 수는 " + LoginImpl.total_user + " 명입니다.</p>");
		//↓여기 변경
		out.print("<hr><br>");
		out.print("<h2>😎현재 접속 중인 사람들😎</h2>");
		List list = (ArrayList)context.getAttribute("user_list");
		for(int i = 0; i < list.size(); i++) {
			out.print("<p>" + (i+1) + ". " + list.get(i) + "</p>");
		}
		//logout누르면 세션 소멸!!
		out.print("<a href='logout?user_id=" + user_id + "'>로그아웃</a>");
		out.print("</body>");
		out.print("</html>");
	}

}
