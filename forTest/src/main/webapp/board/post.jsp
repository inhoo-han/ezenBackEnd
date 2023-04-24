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
<title>글쓰기페이지</title>
</head>
<body bgcolor="#eee" align="center">
	<h2 align="center">✔서버프로그램구현 테스트✔</h2>
	<h3 align="center"><i>ㅡ글쓰기페이지ㅡ</i></h3>
	<hr>

	<form action="${contextPath}/testboard/post.do" method="post">
		<table align="center" >
			<tr>
				<td class="title" width="150" align="center" bgcolor="slateblue">작성자</td>
				<td colspan="2"><input type="text" name="name" size="50"></td>
			</tr>
			<tr>
				<td class="title" width="150" align="center" bgcolor="slateblue">비밀번호</td>
				<td colspan="2"><input type="text" name="pass" size="50"></td>
			</tr>
			<tr>
				<td class="title" width="150" align="center" bgcolor="slateblue">글 제목</td>
				<td colspan="2"><input type="text" name="title" size="50"></td>
			</tr>
			<tr>
				<td class="title" width="150" align="center" bgcolor="slateblue">글 내용</td>
				<td colspan="2"><textarea rows="10" cols="50" name="content" maxlength="4000"></textarea></td>
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