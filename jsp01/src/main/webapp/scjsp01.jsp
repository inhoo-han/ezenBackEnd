<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- [S]선언문 -->
<%!
	//변수 선언
	String name = "강백호";
	
	//메서드
	public String getName() {
		return name + "님 안녕하세요🤗";
	}
%>
<!-- [E]선언문 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언문</title>
</head>
<body bgcolor='#ffcdc0'>
	<!-- [S]표현식 -->
	<h1>😉JSP스크립트요소😉</h1>
	<hr>
	<h3><%=name %>님 환영합니다.</h2>
	<h3><%=getName() %></h2>
	<!-- [E]표현식 -->
</body>
</html> 