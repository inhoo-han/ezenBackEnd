<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- 
<c:set var="articleList" value="${articleMap.articleList}"/>
<c:set var="totArticles" value="${articleMap.totArticles}"/>
<c:set var="section" value="${articleMap.section}"/>
<c:set var="pageNum" value="${articleMap.pageNum}"/>
 -->
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록창</title>
<style type="text/css">
	tr th{
		height: 50px;
		color: #fff;
	}
	.btn_write{
		margin: 30px auto;
		height: 50px;
		width: 150px;
		line-height: 50px;
		border-radius: 25px;
		border: 1px solid #ddd;
	}
	a{
		text-decoration: none;
		color: #333;
	}
	.btn_write:hover{
		background: lightpink;
	}
	.btn_write:hover a{
		color: #fff;
	}
	.selPage {
		color: slateblue;
		font-weight: bold;
	}
	.noLine{
		color: black;
		font-weight: normarl;
	}
</style>
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
			<c:when test="${empty aList}">
				<tr>
					<td colspan="4" align="center">😥등록된 글이 없습니다😥</td>
				</tr>
			</c:when>
			<c:when test="${!empty aList}">
				<c:forEach var="article" items="${aList}" varStatus="articleNum">
					<tr align="center">
						<!-- 
						<td width="5%">${(pageNum-1)*10 + articleNum.count}</td>
						 -->
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
	<!-- 
	<div align="center">
		<c:if test="${totArticles != 0}">
			<c:choose>
				<c:when test="${totArticles > 100}">
					<c:forEach var="page" begin="1" end="10" step="1">
						<c:if test="${section > 1 && page == 1}">
							<a href="${contextPath}/board/listArticles.do?section=${section-1}&pageNum=${(section-1)*10+1}"> prev </a>
						</c:if>
						<a href="${contextPath}/board/listArticles.do?section=${section}&pageNum=${page}">${(section-1)*10+page}</a>
						<c:if test="${page == 10}">
							<a href="${contextPath}/board/listArticles.do?section=${section+1}&pageNum=${section*10+1}"> next </a>
						</c:if>
					</c:forEach>
				</c:when>
				<c:when test="${totArticles <= 100}">
					<c:if test="${(totArticles mod 10) == 0 }">
						<c:set var="totArticles" value="${totArticles-1}" />
					</c:if>
					<c:forEach var="page" begin="1" end="${totArticles/10 + 1}" step="1">
						<c:choose>
							<c:when test="${page==pageNum}">
								<a class="selPage" href="${contextPath}/board/listArticles.do?section=${section}&pageNum=${page}">${page}</a>
							</c:when>
							<c:otherwise>
								<a class="noLine" href="${contextPath}/board/listArticles.do?section=${section}&pageNum=${page}">${page}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</c:when>
			</c:choose>
		</c:if>
	</div>
	 -->
	<p class="btn_write" align="center"><a href="${contextPath}/board/articleForm.do">글쓰기</a></p>
</body>
</html>