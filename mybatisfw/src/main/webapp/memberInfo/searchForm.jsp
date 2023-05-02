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
<title>회원 검색 창</title>
</head>
<body bgcolor="#eee" align="center">
	<h2 align="center">😎MyBatis를 이용한 DB관리😎</h2>
	<h3 align="center"><i>ㅡ🍟동적SQL문🍟ㅡ</i></h3>
	<hr>
	<h4>◾ 회원 검색 ◾</h4>
	<form action="${contextPath}/member4.do">
		<input type="hidden" name="action" value="searchMember">
		🥞 이름 : <input type="text" name="name"><br><br>
		🥞 이메일 : <input type="text" name="email"><br><br>
		<input type="submit" value="검색"><br>
	</form>
</body>
</html>