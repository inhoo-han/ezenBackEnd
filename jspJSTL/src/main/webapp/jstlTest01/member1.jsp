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
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Core태그 라이브러리</title>
</head>
<body>
	<h2 align="center">😎Core태그 라이브러리😎</h2>
	<table border="3" align="center">
		<tr align="center" bgcolor="#BEAEE2">
			<th>아이디</th><th>비밀번호</th><th>이름</th><th>주소</th>
		</tr>
		<tr>
			<td>${id}</td>
			<td>${pwd}</td>
			<td>${name}</td>
			<td>${address}</td>
		</tr>
	</table>
</body>
</html>