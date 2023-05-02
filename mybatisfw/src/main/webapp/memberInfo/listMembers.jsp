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
<style type="text/css">
*{
	text-decoration: none;
	color: #333;	
}
</style>
<title>회원 정보 출력</title>
</head>
<body bgcolor="#eee" align="center">
	<h2 align="center">😎MyBatis를 이용한 DB관리😎</h2>
	<h3 align="center"><i>ㅡ회원정보 출력창ㅡ</i></h3>
	<hr>
	<table border="0" width="700" align="center" bgcolor="#eee">
		<tr align="center" bgcolor="lightpink">
			<th>아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th><th>가입일자</th><th>수정</th><th>삭제</th>
		</tr>
		<c:forEach var="member" items="${memberList}">
			<tr align="center">
				<td>${member.id}</td>
				<td>${member.pwd}</td>
				<td>${member.name}</td>
				<td>${member.email}</td>
				<td>${member.joinDate}</td>
				<td><a href="${contextPath}/member4.do?action=modMember&id=${member.id}">수정</a></td>
				<td><a href="${contextPath}/member4.do?action=delMember&id=${member.id}">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	<p align="center"><a href="${contextPath}/memberInfo/memberForm.jsp">회원가입하기</a></p>
</body>
</html>