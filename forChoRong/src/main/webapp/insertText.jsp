<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, forChoRong.ex01.*"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="memBean" class="forChoRong.ex01.MemberBean" />
<jsp:setProperty property="*" name="memBean" />
<%
	MemberDAO memDAO = new MemberDAO();
	memDAO.addMessage(memBean);
	List messageList = memDAO.listMessage();
	request.setAttribute("messageList", messageList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forword사용</title>
</head>
<body>
	<!-- 받은 값들을 memberJstl.jsp에게 넘겨준다.
	memberJstl.jsp는 해당 값을 클라이언트 화면에 뿌려준다. -->
	<jsp:forward page="messageJstl.jsp"></jsp:forward>
	
</body>
</html>