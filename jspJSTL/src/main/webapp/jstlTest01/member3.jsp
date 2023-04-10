<%-- JSTL 학습 중 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="id" value="baek-ho" scope="page"/>
<c:set var="pwd" value="1031" scope="page"/>
<c:set var="name" value="강백호" scope="page"/>
<c:set var="address" value="파주시 운정동" scope="page"/>
<c:set var="age" value="17" scope="page"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Core태그 라이브러리</title>
</head>
<body>
	<h2 align="center">😎Core태그 라이브러리😎</h2>
	<h3 align="center">ㅡc:if태그 이용해보기ㅡ</h3>
	<hr>
	<c:if test="${id=='baek-ho'}">
		<h4 align="center">😊안녕하세요${name}님!😊</h4>
	</c:if>
	<c:if test="${age<20}">
		<p align="center"><a href="https://blog.naver.com/a5019999">청소년만 볼 수 있는 글입니다.</a></p>
	</c:if>
</body>
</html>