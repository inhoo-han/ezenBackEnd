<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title"/></title>
<link rel="stylesheet" href="${contextPath}/resources/css/layout.css">
</head>
<body>
	<div id="container">
		<header>
			<tiles:insertAttribute name="header"/>
		</header>
		<div id="sidebar-left">
			<tiles:insertAttribute name="side"/>
		</div>
		<div id="content">
			<tiles:insertAttribute name="body"/>
		</div>
		<footer>
			<tiles:insertAttribute name="footer"/>
		</footer>
	</div>
</body>
</html>