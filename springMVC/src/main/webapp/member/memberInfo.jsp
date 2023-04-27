<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 출력창</title>
</head>
<body bgcolor="#eee" align="center">
	<h2 align="center">😎스프링 MVC 연습😎</h2>
	<h3 align="center"><i>ㅡ회원 정보 출력페이지ㅡ</i></h3>
	<hr>
	<table border="0" align="center" width="700">
		<tr align="center" bgcolor="slateblue">
			<th>아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th>
		</tr>
		<tr align="center">
			<td>${id}</td><td>${pwd}</td><td>${name}</td><td>${email}</td>
		</tr>
	</table>
</body>
</html>