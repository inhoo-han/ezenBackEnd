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
<title>게시글보기</title>
<style type="text/css">
	#tr_button_modify{
		display: none;
	}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
/* 수정하기 버튼 눌렀을 때 */
function fn_enable(obj){
	                                //disable -> enable로 변경
	document.getElementById("id_subject").disabled=false;
	document.getElementById("id_content").disabled=false;
	document.getElementById("tr_button_modify").style.display="table-row";
	document.getElementById("tr_button").style.display="none";
}
/* 수정 반영하기 */
function fn_modify_article(obj){
	obj.action = "${contextPath}/testboard/mod.do";
	obj.submit();
}
/* 삭제하기 */
function fn_remove_article(url, num) {
	//d_form이라는 폼을 태그로 생성
	let d_form = document.createElement("form");
	d_form.setAttribute("method", "post");
	d_form.setAttribute("action", url);	
	//글번호 받을 input태그 생성
	let articleNoInput = document.createElement("input");
	articleNoInput.setAttribute("type", "hidden");
	articleNoInput.setAttribute("name", "num");	//"articleNo": articleNo라는 글자가 들어감
	articleNoInput.setAttribute("value", num);	//articleNo: 매개변수articleNo에 담긴 값이 들어감
	//노드를 연결하는 작업
	d_form.appendChild(articleNoInput);
	document.body.appendChild(d_form);
	//BoardController로 보내주는 작업
	d_form.submit();
}
</script>
</head>
<body bgcolor="#eee" align="center">
	<h2 align="center">✔서버프로그램구현 테스트✔</h2>
	<h3 align="center"><i>ㅡ게시물보기페이지>수정중ㅡ</i></h3>
	<hr>
	<form name="frmArticle" action="${contextPath}" method="post">
		<table align="center">
			<tr>
				<td class="title" width="150" align="center" bgcolor="slateblue">글번호</td>
				<td align="left"><input type="text" value="${article.num}" disabled></td>
				<!-- disabled는 값을 전송할 수 없어서 hidden을 이용한다 -->
				<input type="hidden" name="num" value="${article.num}" >
			</tr>
			<tr>
				<td class="title" width="150" align="center" bgcolor="slateblue">작성자</td>
				<td align="left"><input type="text" value="${article.name}" disabled></td>
			</tr>
			<tr>
				<td class="title" width="150" align="center" bgcolor="slateblue">제목</td>
				<td align="left"><input id="id_subject" type="text" name="subject" value="${article.subject}" disabled></td>
			</tr>
			<tr>
				<td class="title" width="150" align="center" bgcolor="slateblue">내용</td>
				<td align="left"><textarea id="id_content" name="content" rows="10" cols="50" disabled>${article.content}</textarea></td>
			</tr>
			
			<tr>
				<td class="title" width="150" align="center" bgcolor="slateblue">등록일자</td>			
				<td align="left"><input type="text" value="<fmt:formatDate value="${article.regdate}"/>" disabled></td>
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
					<input type="button" class="modbtn" value="수정하기" onclick="fn_enable(this.form)">
					<input type="button" value="삭제하기" onclick="fn_remove_article('${contextPath}/testboard/remove.do', ${article.num})">
					<input type="button" value="목록보기" onclick="backToList(this.form)">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>