<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인클루드 액션 태그 활용01</title>
</head>
<body>
	<h1>😁빵이 미니홈피😁</h1>
	<p>(부모JSP)</p>	
	<hr>
	<jsp:include page="img_include.jsp">
		<jsp:param value="빵이" name="name"/>
		<jsp:param value="mycat.png" name="imgName"/>
	</jsp:include>
	<p>🐱‍🏍빵이의 미니홈피에 오신 것을 환영합니다🐱‍🏍<p>
</body>
</html>