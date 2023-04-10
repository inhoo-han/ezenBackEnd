package servletlink.exdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logindb")
public class LoginServletdb extends HttpServlet {

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
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		//인스턴스객체 생성
		MemberVO memVo = new MemberVO();
		//입력받은 값을 넘겨줌
		memVo.setId(user_id);
		memVo.setPwd(user_pwd);
		MemberDAO dao = new MemberDAO();
		//isExisted : 아직 없는 메서드. 이 사람의 id, pwd가 db에 있는지 없는지 물어봄. 있으면 T, 없으면 F
		Boolean result = dao.isExisted(memVo);
		out.print("<html><body>");
		//로그인 결과 여부 판단하는 if-else문
		if(result) {
			//회원정보 확인 => 세션 생성 => 로그인 정보를 세션에 담음(setting)
			HttpSession session = request.getSession();
			session.setAttribute("isLogon", true);
			session.setAttribute("log_id", user_id);
			out.print("😎안녕하세요 " + user_id + "님 방문을 환영합니다.😎");
			//서블릿 이름이 show인 것을 호출하여 회원등급을 확인할 수 있게 함
			out.print("<p><a href='show'>회원등급 확인</a></p>");
		}else {
			//당신, 회원정보 없다 => 다시 로그인해라
			out.print("<p>회원정보가 올바르지 않습니다.</p>");
			out.print("<a href='logindb.html'>다시 로그인하기</a>");
		}
		out.print("");
		out.print("</body></html>");
		
	}
}
