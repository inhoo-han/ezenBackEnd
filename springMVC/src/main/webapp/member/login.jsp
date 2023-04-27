<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>로그인결과창</title>
</head>
<body bgcolor="#eee" align="center">
	<h2 align="center">😎스프링 MVC 연습😎</h2>
	<h3 align="center">ㅡ로그인 결과 페이지ㅡ</h3>
	<hr>
	<h3>로그인 결과</h3>
	<h4>🐋아이디 : ${id}🐋</h4>
	<h4>🐋비밀번호 : ${pwd}🐋</h4>
</body>
</html>