<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("name", "한이누");
	application.setAttribute("address", "서울시 송파구");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>애플리케이션 바인딩 실습01</title>
</head>
<body bgcolor='#ffe3c8'>
	<h2>💻이름은 세션객체에, 주소는 애플리케이션 객체에 저장💻</h2>
	<a href='appTest02.jsp'>두 번째 웹페이지로 이동▶▶</a>
</body>
</html>