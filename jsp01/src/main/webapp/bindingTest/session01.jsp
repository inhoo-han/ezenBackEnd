<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//session객체 생성
	String name = (String)session.getAttribute("name");
	session.setAttribute("address", "서울시 송파구");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 바인딩 실습</title>
</head>
<body>
	<p>✔ 이름은 <%=name %>입니다.</p>
	<a href='session02.jsp'>두 번째 페이지로 이동</a>
</body>
</html>