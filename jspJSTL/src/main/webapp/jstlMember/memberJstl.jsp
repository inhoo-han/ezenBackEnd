<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력 창</title>
</head>
<body bgcolor="#eee">
	<h2 align="center">😎JSTL을 이용한 회원정보 출력😎</h2>
	<hr>
	<table align="center" border="3" width="600">
		<tr align="center" bgcolor="lightpink">
			<th>아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th><th>가입일</th>
		</tr>
		<c:choose>
			<c:when test="${memberList == null}">
				<tr align="center">
					<td colspan="5">😅등록된 회원이 없습니다😅</td>
				</tr>
			</c:when> 
			<c:when test="${memberList != null}">
				<c:forEach var="member" items="${memberList}">
					<tr align="center">
						<td>${member.id}</td>
						<td>${member.pwd}</td>
						<td>${member.name}</td>
						<td>${member.email}</td>
						<td>${member.joinDate}</td>
					</tr>
				</c:forEach>
			</c:when> 
		</c:choose>
	</table>
</body>
</html>