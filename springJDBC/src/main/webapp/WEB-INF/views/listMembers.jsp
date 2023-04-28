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
<title>회원 정보 출력</title>
</head>
<body bgcolor="#eee" align="center">
	<h2 align="center">😎SpringJDBC를 이용한 회원 정보😎</h2>
	<h3 align="center"><i>ㅡ회원 정보 출력ㅡ</i></h3>
	<hr>
	<h3 align="center">회원정보</h3>
	<table border="3" width="600" align="center">
		<tr align="center" bgcolor="lightpink">
			<th>아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th><th>가입일자</th>
		</tr>
		<c:forEach var="member" items="${memberList}">
			<tr align="center">
				<td>${member.id}</td>
				<td>${member.pwd}</td>
				<td>${member.name}</td>
				<td>${member.email}</td>
				<td>${member.joinDate}</td>
			</tr>
		</c:forEach>
	</table>
	<p align="center"><a href="${contextPath}/member/memberForm.do">회원가입하기</a></p>
</body>
</html>