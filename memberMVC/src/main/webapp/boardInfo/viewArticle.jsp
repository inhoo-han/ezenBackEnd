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
	#tr_button_modify{
		display: none;
	}
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
	/* 목록보기 버튼 눌렀을 때*/
	function backToList(obj) {
		obj.action = "${contextPath}/board/listArticles.do";
		obj.submit();
	}
	/* 수정하기 버튼 눌렀을 때 */
	function fn_enable(obj){
		                                //disable -> enable로 변경
		document.getElementById("id_title").disabled=false;
		document.getElementById("id_content").disabled=false;
		//이미지가 없는 글은 이미지 창 자체가 없으므로 따로 설정 필요
		let imgName = document.getElementById("id_imgFile");
		if(imgName != null){
			imgName.disabled=false;
		}
		document.getElementById("tr_button_modify").style.display="table-row";
		document.getElementById("tr_button").style.display="none";
	}
	/* 이미지 미리보기 */
	function readImage(input){
		if(input.files && input.files[0]) {
			let reader = new FileReader();
			reader.onload = function(event) {
				$('#preview').attr('src', event.target.result);
				console.log(event.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	/* 수정 반영하기 */
	function fn_modify_article(obj){
		obj.action = "${contextPath}/board/modArticle.do";
		obj.submit();
	}
	/* 수정하기 버튼 후 취소 눌렀을 때 */
	function toList(obj){
		obj.action="${contextPath}/board/viewArticle.do?articleNo=${article.articleNo}";
		obj.submit();
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
				<td align="left"><input type="text" value="${article.articleNo}" disabled></td>
				<!-- disabled는 값을 전송할 수 없어서 hidden을 이용한다 -->
				<input type="hidden" name="articleNo" value="${article.articleNo}" >
			</tr>
			<tr>
				<td class="title" width="150" align="center" bgcolor="slateblue">작성자</td>
				<td align="left"><input type="text" value="${article.id}" disabled></td>
			</tr>
			<tr>
				<td class="title" width="150" align="center" bgcolor="slateblue">제목</td>
				<td align="left"><input id="id_title" type="text" name="title" value="${article.title}" disabled></td>
			</tr>
			<tr>
				<td class="title" width="150" align="center" bgcolor="slateblue">내용</td>
				<td align="left"><textarea id="id_content" name="content" rows="10" cols="50" disabled>${article.content}</textarea></td>
			</tr>
			<c:if test="${!empty article.imageFileName}">
				<tr>
					<td class="title" width="150" align="center" bgcolor="slateblue" rowspan="2">이미지</td>
					<td align="left">
						<!-- 기존 이미지 받아서 삭제할 거야 -->
						<input type="hidden" name="originalFileName" value="${article.imageFileName}">
						<img id="preview" src="${contextPath}/download.do?imageFileName=${article.imageFileName}&articleNo=${article.articleNo}" width="250">
					</td>
				</tr>
				<tr>
					<td align="left"><input id="id_imgFile" type="file" name="imageFileName" onchange="readImage(this)" disabled></td>
				</tr>
			</c:if>
			<tr>
				<td class="title" width="150" align="center" bgcolor="slateblue">등록일자</td>			
				<td align="left"><input type="text" value="<fmt:formatDate value="${article.writeDate}"/>" disabled></td>
			</tr>
			<!-- 수정하기를 눌러 비활성화를 해제한 뒤, 수정반영할지 여부를 나타내는 버튼 -->
			<tr id="tr_button_modify" align="center">
				<td align="center" colspan="2">
					<input type="button" value="수정반영하기" onclick="fn_modify_article(frmArticle)">
					<input type="button" value="취소" onclick="toList(frmArticle)">
				</td>
			</tr>	
			<tr id="tr_button">
				<td align="center" colspan="2">
					<input type="button" value="수정하기" onclick="fn_enable(this.form)">
					<input type="button" value="삭제하기" onclick="fn_remove_article('${contextPath}/board/removeArticle.do', ${article.articleNo})">
					<input type="button" value="목록보기" onclick="backToList(this.form)">
					<input type="button" value="답글쓰기" onclick="fn_reply_form('${contextPath}/board/replyForm.do', ${article.articleNo})">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>