package mybatisfw.ex03;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatisfw.ex01.MemberVO;

@WebServlet("/member3.do")
public class MemberServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberDAO dao = new MemberDAO();
		MemberVO memberVO = new MemberVO();
		String action = request.getParameter("action");
		String nextPage = "";
		if(action == null || action.equals("listMembers")) {
			List<MemberVO> memberList = dao.selectAllMemberList();
			request.setAttribute("memberList", memberList);
			nextPage = "memberInfo/listMembers.jsp";
		}
		else if(action.equals("selectMemberById")) {
			String id = request.getParameter("value");
			memberVO = dao.selectMemberById(id);
			request.setAttribute("member", memberVO);
			nextPage = "memberInfo/member.jsp";
		}
		else if(action.equals("selectMemberByName")) {
			String name = request.getParameter("value");
			List<MemberVO> memberList = dao.selectMemberByName(name);
			request.setAttribute("memberList", memberList);
			nextPage = "memberInfo/listMembers.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
}
