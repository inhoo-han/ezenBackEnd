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
<title>로그인 결과 페이지</title>
</head>
<body bgcolor="#eee" align="center">
	<h2 align="center">😎Spring @Annotation😎</h2>
	<h3 align="center"><i>ㅡ스프링 어노테이션 실습중입니다ㅡ</i></h3>
	<hr>
	<h3>🍰로그인 결과 페이지🍰</h3>
	<h4>아이디 : ${id}</h4>
	<h4>비밀번호 : ${pwd}</h4>
</body>
</html>