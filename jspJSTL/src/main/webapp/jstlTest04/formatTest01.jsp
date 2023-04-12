<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포맷 태그</title>
</head>
<body bgcolor="#eee">
	<h2 align="center">😎Format태그 라이브러리😎</h2>
	<h3 align="center">ㅡfmt:formatDate태그 이용하여 날짜 출력하기ㅡ</h3>
	<h3 align="center"><i>[type="both"]</i></h3>
	<hr>
	<h4 align="center">
<c:set var="now" value="<%=new Date() %>" />
📆오늘 : ${now}<br>
<fmt:formatDate value="${now}" type="date" var="fdNow" />
📆type="date" 적용 : ${fdNow}<br>
<fmt:formatDate value="${now}" type="date" var="fdNow2" dateStyle="full" />
dateStyle="full" : ${fdNow2}<br>
<fmt:formatDate value="${now}" type="time" var="ftNow" />
📆type="time" 적용 : ${ftNow}<br>
<fmt:formatDate value="${now}" type="both" var="fdtNow" />
type="both" : ${fdtNow}
	</h4>
</body>
</html>