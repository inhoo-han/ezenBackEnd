<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("name", "남궁이누");
	request.setAttribute("address", "서울시 밤섬");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request바인딩 실습01-발신</title>
</head>
<body>
	<%
		RequestDispatcher dispatcher = request.getRequestDispatcher("request02.jsp");
		dispatcher.forward(request,response);
	%>
</body>
</html>