<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String imgName = request.getParameter("imgName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인클루드 액션 태그</title>
</head>
<body>
	<h2>🧡인클루드 액션 태그🧡</h2>
	<p>(자식JSP)</p>	
	<hr>
	<h3>이름은 <%=name %>입니다.</h3>
	<img src="./images/<%=imgName %>" alt="" width="200px">
</body>
</html>