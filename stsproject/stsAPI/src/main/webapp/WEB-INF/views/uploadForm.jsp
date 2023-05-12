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
<title>다중 파일 업로드하기</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	let cnt = 1;
	function fn_addFile() {
		$('#multiFile').append("<input type='file' name='file" +cnt + "'><br><br>");
		cnt++;
	}
</script>
</head>
<body bgcolor="#fffadf" align="center">
	<h2 align="center">😎Maven/STS/다중 파일 업로드😎</h2>
	<h3 align="center"><i>ㅡ파일 업로드하기ㅡ</i></h3>
	<hr>
	<form action="${contextPath}/upload" method="post" enctype="multipart/form-data">
		🍯아이디 : <input type="text" name="id"><br><br>
		🍯이름 : <input type="text" name="name"><br><br>
		<input type="button" value="파일추가" onclick="fn_addFile()">
		<div id="multiFile">
		</div>
		<input type="file" name="file"><br>
		<input type="submit" value="업로드">
	</form>
</body>
</html>