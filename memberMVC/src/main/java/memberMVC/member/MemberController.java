package memberMVC.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	//클래스 객체를 만든다.
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
		
		String nextPage = null;
		//어떤 매핑정보가 오는지에 따라 다른 값이 들어간다.
		String action = request.getPathInfo();
		System.out.println("요청 매핑 이름 : " + action);
		
		/* Controller 조건문 */
		//매핑이름이 null이거나 listMembers.do일 경우 회원목록을 보여주겠다.
		if(action == null || action.equals("/listMembers.do")) {
			//MemberDAO에 있는 listMembers()메서드를 통해 담긴 값을 memberList에 넣었다.
			List<MemberVO> memberList = memberDAO.listMembers();
			//회원 정보 바인딩
			request.setAttribute("memberList", memberList);
			nextPage="/memberInfo/listMembers.jsp";
		} 
		
		//매핑이름이 memberForm.do일 경우 회원가입창을 보여주겠다.
		else if(action.equals("/memberForm.do")) {
			nextPage = "/memberInfo/memberForm.jsp";
		} 
		
		//memberForm.do에서 회원가입을 누르면 addMember.do로 연결(form의 action이 addMember.do였음)
		else if(action.equals("/addMember.do")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memberVO = new MemberVO(id, pwd, name, email);
			//memberDAO에 있는 addMember메서드를 호출하면서 memberVO에 있는 데이터를 넘겨준다.
			memberDAO.addMember(memberVO);
			request.setAttribute("msg", "addMember");
			nextPage="/member/listMembers.do";
		} 
		
		//listMember.jsp에서 보낸 modMemberForm.do(수정)를 받음
		else if(action.equals("/modMemberForm.do")) {
			String id = request.getParameter("id");
			MemberVO memFindInfo = memberDAO.findMember(id);
			//전달받은 값을 다시 설정
			request.setAttribute("memFindInfo", memFindInfo);
			//다음 페이지는 수정하기 위한 Form입니다
			nextPage = "/memberInfo/modMemberForm.jsp";
		} 
		
		//modMemberForm.jsp에서 값 수정 후 수정하기 버튼을 눌렀을 때
		else if(action.equals("/modMember.do")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memberVO = new MemberVO(id, pwd, name, email);
			//수정하기 버튼을 누르면 값이 새롭게 UPDATE된다. 
			memberDAO.modMember(memberVO);
			//수정이 완료된 뒤 다시 listMembers창을 보여준다.
			request.setAttribute("msg", "modified");
			nextPage="/member/listMembers.do";
		}
		
		//listMember.jsp에서 보낸 delMember.do(삭제)를 받음
		else if(action.equals("/delMember.do")) {
			String id = request.getParameter("id");
			memberDAO.delMember(id);
			request.setAttribute("msg", "deleted");
			nextPage = "/member/listMembers.do";
		}
		
		//주소를 잘못 입력한 경우, 전부 listMembers가 보이게 한다. (에러창 대신)
		else {
			List<MemberVO> memberList = memberDAO.listMembers();
			request.setAttribute("memberList", memberList);
			nextPage="/memberInfo/listMembers.jsp";
		}
		
		//컨트롤러에서 nextPage에 담긴 값으로 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
}
