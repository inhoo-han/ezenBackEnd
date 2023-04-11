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
<c:set var="name" value="${'강백호'}" scope="page"/>
<c:set var="age" value="${17}" scope="page"/>
<c:set var="height" value="${188}" scope="page"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Core태그 라이브러리</title>
</head>
<body>
	<h2 align="center">😎Core태그 라이브러리😎</h2>
	<h3 align="center">ㅡc:choose태그 이용해보기ㅡ</h3>
	<table border="3" align="center">
		<tr align="center" bgcolor="#ffe3c8">
			<th>아이디</th><th>비밀번호</th><th>이름</th><th>나이</th><th>키</th>
		</tr>
		<c:choose>
			<%-- 아래와 같은 표현 => <c:when test="${name==null}"></c:when> --%>
			<c:when test="${empty name}">
				<tr align="center">
					<td colspan="5">👀이름을 입력해 주세요👀</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td>${id}</td>
					<td>${pwd}</td>
					<td>${name}</td>
					<td>${age}</td>
					<td>${height}</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>