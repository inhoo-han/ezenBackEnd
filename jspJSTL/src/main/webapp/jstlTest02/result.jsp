<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과창</title>
</head>
<body bgcolor="#eee">
	<h2 align="center">😎Core태그 라이브러리 - 문제😎</h2>
	<h3 align="center">ㅡc:if태그 이용하여 로그인 결과 출력하기ㅡ</h3>
	<hr>
	<!-- [1]아이디가 비어있을 때 -->
	<c:if test="${empty param.user_id }">
		<h4 align="center">👀아이디를 입력해주세요👀</h4>
		<a align="center" href="login.jsp">다시 로그인하기</a>
	</c:if>
	<!-- [2]아이디가 비어있지 않을 때 -->
	<c:if test="${not empty param.user_id}">
		<!-- [2-1]아이디가 admin일 때 -->
		<c:if test="${param.user_id == 'admin'}">
			<h4 align="center">👀관리자님 어서오십시오!👀</h4>
			<input type="button" value="메롱"/>
			<input type="button" value="바보"/>
		</c:if>
		<!-- [2-2]아이디가 admin이 아닐 때 -->
		<c:if test="${param.user_id != 'admin'}">
			<h4 align="center">👀${param.user_id}님 안녕하세요!👀</h4>
		</c:if>
	</c:if>	
</body>
</html>