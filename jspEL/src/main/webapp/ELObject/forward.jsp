<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	request.setAttribute("address", "파주시 운정동");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포워딩 실습</title>
</head>
<body>
	<h2>포워딩forwarding 실습</h2>
	<jsp:forward page="member3.jsp"></jsp:forward>
</body>
</html>