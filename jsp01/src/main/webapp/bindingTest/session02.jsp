<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)session.getAttribute("name");
	String address = (String)session.getAttribute("address");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 바인딩 실습2</title>
</head>
<body>
	<p>✔ 이름은 <%=name %>입니다.</p>	
	<p>✔ 주소는 <%=address %>입니다.</p>	
</body>
</html>