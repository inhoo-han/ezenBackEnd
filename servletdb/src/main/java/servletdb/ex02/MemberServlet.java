package servletdb.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member2")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.listMembers();
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h2> 😎😎 Member 여러분 환영해요 😎😎 </h2>");
		out.print("<table border=3>");
		out.print("<tr align='center' bgcolor='#f00077'>");
		out.print("<th>아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th><th>가입일</th>");
		out.print("</tr>");
		for(int i=0; i<list.size(); i++) {
			String id = list.get(i).getId();
			String pwd = list.get(i).getPwd();
			String name = list.get(i).getName();
			String email = list.get(i).getEmail();
			Date joinDate = list.get(i).getJoinDate();
			out.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>" + name + "</td><td>" + email + "</td><td>" + joinDate + "</td>");
		}
		out.print("</table>");
		out.print("</body></html>");
		
	}
}
