<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인클루드 액션 태그 활용02</title>
</head>
<body>
	<h1>😁빵이에게 물어봐용😁</h1>
	<p>(서브페이지)</p>	
	<hr>
	<jsp:include page="img_include.jsp">
		<jsp:param value="소통냥빵이" name="name"/>
		<jsp:param value="mycat2.png" name="imgName"/>
	</jsp:include>
	<p>🐱‍🏍빵이에게 궁금한것 다 물어봐🐱‍🏍<p>
</body>
</html>