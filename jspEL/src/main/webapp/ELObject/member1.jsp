<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 기존방식 --%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현언어로 회원정보 출력</title>
</head>
<body>
	<h2 align="center">기존방식을 이용해 회원정보 출력</h2>
	<table border="3" align="center">
		<tr align="center" bgcolor="lightyellow">
			<th>아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th>
		</tr>
		<tr>
			<td><%=id %></td><td><%=pwd %></td><td><%=name %></td><td><%=email %></td>
		</tr>
	</table>
</body>
</html>