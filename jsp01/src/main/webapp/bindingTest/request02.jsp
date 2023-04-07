<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)request.getAttribute("name");
	String address = (String)request.getAttribute("address");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request바인딩 실습02-수신</title>
</head>
<body bgcolor='#ccc'>
	<h2>💻request바인딩💻</h2>
	<p>✔ 이름은 <%=name %>입니다.</p>
	<p>✔ 주소는 <%=address %>입니다.</p>
	<a href='request01.jsp'>첫 번째 리퀘스트 페이지로 이동▶▶</a>
</body>
</html>