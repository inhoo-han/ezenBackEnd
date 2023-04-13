<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="file1" value="${param.param1}" />
<c:set var="file2" value="${param.param2}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다운로드 창</title>
</head>
<body bgcolor="#eee">
	<h2 align="center">😎JSP로 파일 다루기😎</h2>
	<h3 align="center"><i>ㅡ다운로드 창ㅡ</i></h3>
	<hr>
	<h4 align="center">
		첫 번째 이미지 : ${file1}<br>
		<c:if test="${not empty file1}">
			<img src="${contextPath}/download.do?fileName=${file1}" width="300"><br>
		</c:if>
		<a href="${contextPath}/download.do?fileName=${file1}">파일 내려받기</a><br>
		<br>* * * * * * * * * *<br><br>
		두 번째 이미지 : ${file2}<br>
		<c:if test="${not empty file2}">
			<img src="${contextPath}/download.do?fileName=${file2}" width="300"><br>
		</c:if>
		<a href="${contextPath}/download.do?fileName=${file2}">파일 내려받기</a><br>
	</h4>
</body>
</html>