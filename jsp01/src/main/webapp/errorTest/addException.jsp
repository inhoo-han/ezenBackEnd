<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="#ffe3c8">
	<h2>➕합계를 구하는 도중 에러가 발생했어요➕</h2>
	<hr>
	<h2>에러 내용</h2>
	<!--<h3>👀1. getMessage()      : <%=exception.getMessage() %></h3>
	 <p>입력한 값이 위와 같아 예외가 발생하였다.</p> -->
	
	<!--<h3>👀2. toString()        : <%=exception.toString() %></h3>
	<p>에러 발생 원인과, 사용자가 입력한 값입니다.</p> -->
	
	<!--<h3>👀3. printStackTrace() : <% exception.printStackTrace(); %></h3>
	<p>이클립스 콘솔로 예외 메시지를 보여준다.</p> -->
	
	<h3>숫자만 입력 가능합니다. 다시 시도해 보세요!▶▶<a href="adder.html">다시하기</a></h3>
</body>
</html>