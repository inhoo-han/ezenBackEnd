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
<c:choose>
	<%-- 등록시 출력 메세지 --%>
	<c:when test="${msg=='addMember'}">
		<script>
			window.onload = function() {
				alert("회원을 등록했습니다.");
			}
		</script>
	</c:when>
	<%-- 수정시 출력 메세지 --%>
	<c:when test="${msg=='modified'}">
		<script>
			window.onload = function() {
				alert("회원 정보를 수정했습니다.");
			}
		</script>
	</c:when>
	<%-- 삭제시 출력 메세지 --%>
	<c:when test="${msg=='deleted'}">
		<script>
			window.onload = function() {
				alert("회원정보를 삭제했습니다.");
			}
		</script>
	</c:when>
</c:choose>
</head>
<body bgcolor="#eee" align="center">
	<h2 align="center">😎회원정보😎</h2>
	<h3 align="center"><i>ㅡMVC를 이용한다ㅡ</i></h3>
	<hr>
	<table border="3" width="600" align="center">
		<tr align="center" bgcolor="lightpink">
			<th>아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th><th>가입일자</th><th>수정</th><th>삭제</th>
		</tr>
		<c:choose>
			<c:when test="${empty memberList}">
				<tr>
					<td colspan="5" align="center">😅등록된 회원이 없습니다😅</td>
				</tr>
			</c:when>
			<c:when test="${not empty memberList}">
				<c:forEach var="mem" items="${memberList}">
					<tr align="center">
						<td>${mem.id}</td>
						<td>${mem.pwd}</td>
						<td>${mem.name}</td>
						<td>${mem.email}</td>
						<td>${mem.joinDate}</td>
						<td><a style="text-decoration: none;" href="${contextPath}/member/modMemberForm.do?id=${mem.id}">수정</a></td>
						<td><a style="text-decoration: none;" href="${contextPath}/member/delMember.do?id=${mem.id}">삭제</a></td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	<p align="center"><a href="${contextPath}/member/memberForm.do">회원가입하기</a></p>
</body>
</html>