<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입창</title>
</head>
<body bgcolor="#eee" align="center">
	<h2 align="center">😎SpringJDBC를 이용한 회원 정보😎</h2>
	<h3 align="center"><i>ㅡ회원 가입창ㅡ</i></h3>
	<hr>
	<form action="${contextPath}/member/addMember.do" method="post">
		<h3>회원 가입하기</h3>
		<table align="center">
			<tr>
				<td width="100"><p align="left">◾ 아이디</p></td>
				<td width="400"><input type="text" name="id"></td>
			</tr>
			<tr>
				<td width="100"><p align="left">◾ 비밀번호</p></td>
				<td width="400"><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td width="100"><p align="left">◾ 이름</p></td>
				<td width="400"><input type="text" name="name"></td>
			</tr>
			<tr>
				<td width="100"><p align="left">◾ 이메일</p></td>
				<td width="400"><input type="email" name="email"></td>
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