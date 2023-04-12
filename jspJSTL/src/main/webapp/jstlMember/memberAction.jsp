<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, jspJSTL.ex01.*"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%-- bean은 class라는 뜻이니까 MemberBean이라는 클래스(bean)을 사용하겠다는 뜻. 인스턴트 객체 생성 --%>
<jsp:useBean id="memBean" class="jspJSTL.ex01.MemberBean" />
<jsp:setProperty property="*" name="memBean" />
<%-- 아래 부분은 나중에 MVC에서 할 것! --%>
<%
	MemberDAO memDAO = new MemberDAO();
	memDAO.addMember(memBean);
	List memberList = memDAO.listMembers();
	request.setAttribute("memberList", memberList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션태그를 이용한 DB활용</title>
</head>
<body>
	<!-- 받은 값들을 memberJstl.jsp에게 넘겨준다.
	memberJstl.jsp는 해당 값을 클라이언트 화면에 뿌려준다. -->
	<jsp:forward page="memberJstl.jsp"></jsp:forward>
</body>
</html>