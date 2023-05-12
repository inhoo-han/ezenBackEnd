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
<title>글쓰기 창</title>
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
	input[type=button], input[type=submit]{
		height: 50px;
		width: 150px;
		line-height: 50px;
		border-radius: 25px;
		border: 1px solid #ddd;
	}
	input[type=button]:hover, input[type=submit]:hover{
		background: lightpink;
		color: #fff;
	}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	//이미지 미리보기 구현
	function readImage(input){
		if(input.files && input.files[0]) {
			let reader = new FileReader();
			reader.onload = function(event) {
				$('#preview').attr('src', event.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	
	//다른 액션을 submit
	function toList(obj){
		obj.action = "${contextPath}/board/listArticles.do";
		obj.submit();
	}
</script>
</head>
<body bgcolor="#eee" align="center">
	<h2 align="center">😎계층형 게시판 만들기😎</h2>
	<h3 align="center"><i>ㅡ글쓰기 창ㅡ</i></h3>
	<hr>
	<form action="${contextPath}/board/addArticle.do" method="post" enctype="multipart/form-data">
		<table align="center" >
			<tr>
				<td class="title" width="150" align="center" bgcolor="slateblue">글 제목</td>
				<td colspan="2"><input type="text" name="title" size="50"></td>
			</tr>
			<tr>
				<td class="title" width="150" align="center" bgcolor="slateblue">글 내용</td>
				<td colspan="2"><textarea rows="10" cols="50" name="content" maxlength="4000"></textarea></td>
			</tr>
			<tr>
				<td class="title" width="150" align="center" bgcolor="slateblue">이미지 파일 첨부</td>
				<td>
					<input type="file" name="imageFileName" onchange="readImage(this)">
					<img id="preview" src="#" width="200" height="200">
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="등록하기">
					<input type="button" value="목록보기" onclick="toList(this.form)">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>