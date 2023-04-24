package forSecondTest.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/secondTest/*")
public class MemberController extends HttpServlet {
	MemberDAO memberDAO;
	public void init(ServletConfig config) throws ServletException {
		memberDAO = new MemberDAO();
	}
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
		String nextPage = null;
		//어떤 매핑정보가 오는지에 따라 다른 값이 들어간다.
		String action = request.getPathInfo();
		System.out.println("요청 매핑 이름 : " + action);
		
		if(action.equals("/addMember.do")) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			String telecom = request.getParameter("telecom");
			int telno = Integer.parseInt(request.getParameter("telno"));
			
			MemberVO memberVO = new MemberVO(name, email, pass, telecom, telno);
			memberDAO.addMember(memberVO);
			request.setAttribute("msg", "addMember");
			out = response.getWriter();
			out.print("<script>");
			out.print("alert('🤗회원가입되었습니다🤗');");
			out.print("</script>");
		}
		//로그인
		else if(action.equals("/login.do")) {
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			
			MemberVO memberVO = new MemberVO(email, pass);
			String msg = memberDAO.loginMember(memberVO);
			request.setAttribute("name", "name");
			out = response.getWriter();
			out.print("<script>");
			out.print("alert('" + msg + "');");
			out.print("</script>");
		}
	}
}
