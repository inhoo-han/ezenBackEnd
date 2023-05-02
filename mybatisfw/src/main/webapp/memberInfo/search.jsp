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
	<h3 align="center"><i>ㅡ회원 검색창ㅡ</i></h3>
	<hr>
	<form action="${contextPath}/member3.do">
		🥞조회 : <input type="search" name="value">
		<select name="action">
			<option value="listMembers">전체</option>
			<option value="selectMemberById">아이디</option>
			<option value="selectMemberByName">이름</option>
		</select>
		<input type="submit" value="검색">
	</form>
</body>
</html>