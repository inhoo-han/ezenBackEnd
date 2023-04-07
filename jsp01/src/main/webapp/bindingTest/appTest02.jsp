<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)session.getAttribute("name");
	String address = (String)application.getAttribute("address");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>애플리케이션 바인딩 실습02</title>
</head>
<body bgcolor='#fff8b2'>
	<h2>💻이름은 세션객체에, 주소는 애플리케이션 객체에 저장💻</h2>
	<p>✔ 이름은 <%=name %>입니다.</p>
	<p>✔ 주소는 <%=address %>입니다.</p>
	<a href='appTest01.jsp'>첫 번째 웹페이지로 이동▶▶</a>
</body>
</html>