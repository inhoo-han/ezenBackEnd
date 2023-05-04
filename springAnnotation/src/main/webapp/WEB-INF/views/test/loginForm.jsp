<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지</title>
</head>
<body bgcolor="#eee" align="center">
	<h2 align="center">😎Spring @Annotation😎</h2>
	<h3 align="center"><i>ㅡ스프링 어노테이션 실습중입니다ㅡ</i></h3>
	<hr>
	<h3>🍰로그인페이지🍰</h3>
	<form action="${contextPath}/test/login.do" method="post">
		아이디 : <input type="text"	name="id"><br><br>
		비밀번호 : <input type="password"	name="pwd"><br><br>
		<input type="submit" value="로그인">
		<input type="reset" value="다시입력">
	</form>
</body>
</html>