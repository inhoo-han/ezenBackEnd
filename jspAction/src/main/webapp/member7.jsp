<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, jspAction.ex01.*"
    %>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="memBean" class="jspAction.ex01.MemberBean" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="memBean"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 페이지</title>
</head>
<body>
	<h2 align="center">회원 목록</h2>
	<hr>
	<table border="3" align="center">
		<tr align="center" bgcolor="fff2c8">
			<th>아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th>
		</tr>
		<tr align="center">
			<td><jsp:getProperty property="id" name="memBean"/></td>
			<td><jsp:getProperty property="pwd" name="memBean"/></td>
			<td><jsp:getProperty property="name" name="memBean"/></td>
			<td><jsp:getProperty property="email" name="memBean"/></td>
		</tr>
	</table>
		<p align="center"><a href="memberForm.html">새 회원 등록하기</a></p>
</body>
</html>