<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업로드 결과창</title>
</head>
<body bgcolor="#fffadf" align="center">
	<h2 align="center">😎Maven/STS/다중 파일 업로드😎</h2>
	<hr>
	<h3 align="center"><i>ㅡ파일 업로드가 완료되었습니다ㅡ</i></h3>
	<h4> 아이디 : ${map.id}</h4>
	<h4> 이름 : ${map.name}</h4>
	<div>
		<c:forEach var="imageFileName" items="${map.fileList}">
			<img src="${contextPath}/download?imageFileName=${imageFileName}"><br>
			<p>${imageFileName}</p>
		</c:forEach>
	</div>

</body>
</html>