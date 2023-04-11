<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다국어 페이지</title>
</head>
<body>
	<a href="main_ko.jsp">한국어</a>  <a href="main_en.jsp">English</a>
	<fmt:setLocale value="ko_KR"/>
	<fmt:bundle basename="resource.main">
		<h1><fmt:message key="mem.title" /></h1>
		<p><fmt:message key="mem.name" /></p>
		<p><fmt:message key="mem.address" /></p>
		<p><fmt:message key="mem.job" /></p>
	</fmt:bundle>
</body>
</html>