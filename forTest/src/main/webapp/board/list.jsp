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
<title>리스트페이지</title>
</head>
<body bgcolor="#eee" align="center">
	<h2 align="center">✔서버프로그램구현 테스트✔</h2>
	<h3 align="center"><i>ㅡ리스트페이지ㅡ</i></h3>
	<hr>
	
	<table align = "center" border="0" width="80%">
		<tr align = "center" bgcolor = "slateblue">
			<th>글번호</th><th>작성자</th><th>제목</th><th>작성일</th><th>조회수</th>
		</tr>
		<c:choose>
			<c:when test="${empty boardList}">
				<tr>
					<td colspan="5" align="center">😥등록된 글이 없습니다😥</td>
				</tr>
			</c:when>
			<c:when test="${!empty boardList}">
				<c:forEach var="article" items="${boardList}">
					<tr align="center">
						<td width="8%">${article.num}</td>
						<td width="10%">${article.name}</td>
						<td width="50%"><a href="${contextPath}/testboard/read.do?num=${article.num}">${article.subject}</a></td>
						<td width="10%">${article.regdate}</td>
						<td width="10%">${article.count}</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	<p class="btn_write" align="center"><a href="${contextPath}/board/post.jsp">글쓰기</a></p>
</body>
</html>