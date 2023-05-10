<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="result" value="${param.result}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입창</title>
<c:if test="${result == 'loginFailed'}">
	<script>
		window.onload=function() {
			alert("😔아이디와 비밀번호가 일치하지 않습니다😔다시 로그인해주세요.");
		}
	</script>
</c:if>
</head>
<body align="center">
	<h2 align="center">😎Maven/STS/Tiles😎</h2>
	<h3 align="center"><i>ㅡ로그인 창ㅡ</i></h3>
	<hr>
	<form action="${contextPath}/member/login.do" method="post">
		<table align="center">
			<tr>
				<td><p align="right">아이디</p></td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td><p align="right">비밀번호</p></td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td colspan="2">
					<br><input type="submit" value="login">
					<input type="reset" value="reset">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>