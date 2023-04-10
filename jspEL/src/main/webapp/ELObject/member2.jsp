<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 기존방식 --%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%-- getParameter대신에 param객체를 이용한다. --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현언어의 param내장객체를 이용해 회원정보 출력</title>
</head>
<body>
	<h2 align="center">표현언어의 param내장객체를 이용해 회원정보 출력</h2>
	<table border="3" align="center">
		<tr align="center" bgcolor="lightyellow">
			<th>아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th>
		</tr>
		<tr>
			<td>${param.id}</td><td>${param.pwd}</td><td>${param.name}</td><td>${param.email}</td>
		</tr>
	</table>
</body>
</html>