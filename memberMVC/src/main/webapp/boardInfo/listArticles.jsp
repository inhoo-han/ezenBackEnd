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
<title>글 목록창</title>
</head>
<body bgcolor="#eee" align="center">
	<h2 align="center">😎계층형 게시판 만들기😎</h2>
	<h3 align="center"><i>ㅡ글 목록창ㅡ</i></h3>
	<hr>
	<table align = "center" border="0" width="80%">
		<tr align = "center" bgcolor = "slateblue">
			<th>글번호</th><th>작성자</th><th>제목</th><th>작성일</th>
		</tr>
		<c:choose>
			<c:when test="${empty articleList}">
				<tr>
					<td colspan="4" align="center">😥등록된 글이 없습니다😥</td>
				</tr>
			</c:when>
			<c:when test="${!empty articleList}">
				<c:forEach var="article" items="${articleList}" varStatus="articleNum">
					<tr align="center">
						<td width="5%">${articleNum.count}</td>
						<td width="10%">${article.id}</td>
						<td width="50%" align="left">
							<span style="padding-left: 10px"></span>
							<c:choose>
								<c:when test="${article.level > 1}">
									<c:forEach begin="1" end="${article.level}" step="1">
										<span style="padding-left: 20px"></span>
									</c:forEach>
									<span>[답변]<a href="${contextPath}/board/viewArticle.do?articleNo=${article.articleNo}">${article.title}</a></span>
								</c:when>
								<c:otherwise>
									<a href="${contextPath}/board/viewArticle.do?articleNo=${article.articleNo}">${article.title}</a>
								</c:otherwise>
							</c:choose>
						</td>
						<td width="10%">${article.writeDate}</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	<p align="center"><a href="${contextPath}/board/articleForm.do">글쓰기</a></p>
</body>
</html>