<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="addException.jsp" %>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	int sum = 0;
	for(int i=1; i<=num; i++){
		sum += i;	
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>합계 구하는 프로그램</title>
</head>
<body bgcolor='#fff8b2'>
	<h2>➕합계를 구했어요➕</h2>
	<hr>
	<h3>1부터 [<%=num %>]까지의 합은 [<%=sum %>]입니다.<h3>
</body>
</html>