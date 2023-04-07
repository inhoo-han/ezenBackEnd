package servletAPI.exdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewMember")
public class ViewServlet extends HttpServlet {

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
		List memberList = (List)request.getAttribute("memberList");
		//예전MemberServlet에서 복붙해왓슴
		out.print("<html><body>");
		out.print("<h2> 😎😎 어쉉세요 😎😎 </h2>");
		out.print("<table border=3>");
		out.print("<tr align='center' bgcolor='#7000ff'>");
		out.print("<th>아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th><th>가입일</th><th>삭제</th>");
		out.print("</tr>");
		for(int i=0; i<memberList.size(); i++) {
			MemberVO memVO = (MemberVO)memberList.get(i);
			String id = memVO.getId();
			String pwd = memVO.getPwd();
			String name = memVO.getName();
			String email = memVO.getEmail();
			Date joinDate = memVO.getJoinDate();
			out.print("<tr><td>" + id + "</td><td>" + pwd + 
					"</td><td>" + name + "</td><td>" + email + 
					"</td><td>" + joinDate + "</td><td>" + 
					"<a href='member?command=delMember&id=" + id + "'>삭제</a>" +
					"</td></tr>");
		}
		out.print("</table>");
		out.print("<a href='/servletAPI/memberForm.html'>새 회원 등록하기");
		out.print("</body></html>");
	}

}
