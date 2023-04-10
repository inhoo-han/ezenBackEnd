<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    import="java.util.*, jspEL.ex01.*" %>
<!-- useBean을 이용하여 빈 객체 생성 -->
<jsp:useBean id="memBean" class="jspEL.ex01.MemberBean" scope="page"/>
<jsp:useBean id="list" class="java.util.ArrayList" scope="page"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현언어</title>
</head>
<body bgcolor="#eee">
	<h2>📰표현언어의 empty연산자📰</h2>
	<h3>
		<b>MemberBean 객체 설정</b><br>
		\${empty memBean} = ${empty memBean}<br>
		\${not empty memBean} = ${not empty memBean}<br>
		<br><b>ArrayList 객체 설정</b><br>
		\${empty list} = ${empty list}<br>
		\${not empty list} = ${not empty list}<br>
	</h3>
</body>
</html>