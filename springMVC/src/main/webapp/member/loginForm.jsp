<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인창</title>
</head>
<body bgcolor="#eee" align="center">
	<h2 align="center">😎스프링 MVC 연습😎</h2>
	<h3 align="center">ㅡ로그인 페이지ㅡ</h3>
	<hr>
	<form action="${contextPath}/member/login.do" method="post">
		🐋아이디 : <input type="text" name="id"><br>
		🐋비밀번호 : <input type="password" name="pwd"><br>
		<input type="submit" value="로그인">
		<input type="reset" value="초기화">
	</form>
</body>
</html>