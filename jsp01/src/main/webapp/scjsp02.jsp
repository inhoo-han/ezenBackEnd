<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 선언문 -->
<%! String name = "강백호"; %>
<!-- 스크립트릿 -->
<%
	String age = request.getParameter("age");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트릿 실습</title>
</head>
<body>
	<h1>JSP스크립트요소</h1>
	<p>스크립트릿 실습 중</p>
	<hr>
	<p>🏀 여러분 안녕하세요, 제 이름은 <%=name %>입니다.</p>
	<p>🏀 제 나이는 <%=age %>살입니다. 반갑습니다.</p>
	<p>🏀 제 신장은 <%=188 %>cm 입니다.</p>
	<p>🏀 10년 후 제 나이는 <%=Integer.parseInt(age)+10 %>살입니다.</p>
</body>
</html>