<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다운로드 요청창</title>
</head>
<body bgcolor="#eee">
	<h2 align="center">😎JSP로 파일 다루기😎</h2>
	<h3 align="center"><i>ㅡ파일을 다운로드하기ㅡ</i></h3>
	<hr>
	<form align="center" action="downLoad.jsp" method="post">
		<input type="hidden" name="param1" value="mycat_bbang.png">
		<input type="hidden" name="param2" value="merong.png">
		↓  ↓  click!  ↓  ↓<br><br>
		→    <input type="submit" value="이미지 다운로드">    ←<br><br>
		↑  ↑  click!  ↑  ↑
	</form>
	
</body>
</html>