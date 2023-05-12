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
<title>사이드</title>
</head>
<body>
	<h2>🍟사이드 메뉴🍟</h2>
	<h3><a href="${contextPath}/member/listMembers.do">회원관리</a></h3>
	<h3>상품관리</h3>
	<h3>커뮤니티</h3>
	<h3><a href="${contextPath}/board/listArticles.do">게시판</a></h3>
</body>
</html>