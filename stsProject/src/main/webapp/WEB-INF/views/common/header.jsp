<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더</title>
</head>
<body>
	<table width="100%">
		<tr>
			<td>
				<a href="${contextPath}/main.do"><img width="200" src="${contextPath}/resources/images/mycat.png"></a>
			</td>
			<td><h1>🥓타일즈 활용 연습 홈페이지🥓</h1></td>
			<td>
				<c:choose>
					<c:when test="${isLogOn == true && member != null}">
						<h3>환영합니다. ${member.name}님!!</h3>
						<a href="${contextPath}/member/login.do">🥚로그아웃🥚</a>
					</c:when>
					<c:otherwise>
						<a href="${contextPath}/member/loginForm.do">🥚로그인🥚</a>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
</body>
</html>