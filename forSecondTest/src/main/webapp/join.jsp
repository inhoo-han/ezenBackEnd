<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body bgcolor="#eee" align="center">
	<h2 align="center">✔서버프로그램구현 테스트✔</h2>
	<h3 align="center"><i>ㅡ회원가입페이지ㅡ</i></h3>
	<hr>
	
	<form action="${contextPath}/secondTest/addMember.do" method="post">
		<h3>회원 가입하기</h3>
		<table align="center">
			<tr>
				<td width="100"><p align="left">◾ 이름</p></td>
				<td width="400"><input type="text" name="name"></td>
			</tr>
			<tr>
				<td width="100"><p align="left">◾ 이메일</p></td>
				<td width="400"><input type="email" name="email"></td>
			</tr>
			<tr>
				<td width="100"><p align="left">◾ 비밀번호</p></td>
				<td width="400"><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td width="100"><p align="left">◾ 통신사</p></td>
				<td width="400"><input type="text" name="telecom"></td>
			</tr>
			<tr>
				<td width="100"><p align="left">◾ 전화번호</p></td>
				<td width="400"><input type="text" name="telno"></td>
			</tr>
			<tr>
				<td width="100">&nbsp;</td>
				<td width="400">
					<input type="reset" value="다시입력">
					<input type="submit" value="가입하기">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>