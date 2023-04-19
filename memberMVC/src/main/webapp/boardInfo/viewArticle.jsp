<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세 보기</title>
<style type="text/css">
td{
	border-radius: 3px;
}
.title{
	color: #fff;
}
textarea{
	resize: none;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function backToList(obj) {
		obj.action = "${contextPath}/board/listArticles.do";
	}
</script>
</head>
<body bgcolor="#eee" align="center">
	<h2 align="center">😎계층형 게시판 만들기😎</h2>
	<h3 align="center"><i>ㅡ글 상세보기ㅡ</i></h3>
	<hr>
	<form name="frmArticle" action="${contextPath}" method="post" enctype="multipart/form-data">
		<table align="center">
			<tr>
				<td class="title" width="150" align="center" bgcolor="slateblue">글번호</td>
				<td><input type="text" value="${article.articleNo}" disabled></td>
			</tr>
			<tr>
				<td class="title" width="150" align="center" bgcolor="slateblue">작성자</td>
				<td><input type="text" value="${article.id}" disabled></td>
			</tr>
			<tr>
				<td class="title" width="150" align="center" bgcolor="slateblue">제목</td>
				<td><input type="text" value="${article.title}" disabled></td>
			</tr>
			<tr>
				<td class="title" width="150" align="center" bgcolor="slateblue">내용</td>
				<td><textarea rows="10" cols="50" disabled>${article.content}</textarea></td>
			</tr>
			<c:if test="${!empty article.imageFileName}">
				<tr>
					<td class="title" width="150" align="center" bgcolor="slateblue" rowspan="2">이미지</td>
					<td>
						<input type="hidden" name="originalFileName" value="${article.imageFileName}">
						<img src="${contextPath}/download.do?imageFileName=${article.imageFileName}&articleNo=${article.articleNo}">
					</td>
				</tr>
			</c:if>
			<tr>
				<td class="title" width="150" align="center" bgcolor="slateblue">등록일자</td>			
				<td><input type="text" value="<fmt:formatDate value="${article.writeDate}"/>" disabled></td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input type="button" value="수정하기">
					<input type="button" value="삭제하기">
					<input type="button" value="목록보기" onclick="backToList(this.form)">
					<input type="button" value="답글쓰기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>