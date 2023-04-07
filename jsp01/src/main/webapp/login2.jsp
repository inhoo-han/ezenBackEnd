<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 외부에서 받아 온 값은 맨 위에 써주는 것이 좋다. -->
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("user_id");
	String pwd = request.getParameter("user_pwd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과 출력</title>
</head>
<body bgcolor = '#fff8b2'>
	<h1>🐱‍🐉로그인 정보2🐱‍🐉</h1>
	<hr>
	<%
		if(id == null || id.length() == 0){
	%>
			<p style="color: red;">👀아이디를 입력해주세요👀</p>
			<a href="/jsp01/login.html">로그인 다시하기</a>
	<%
		} /*if문 닫기*/ else if(id.equals("admin")){
	%>
			<h2>[system] 관리자로 로그인하였습니다.</h2>
			<p><b>관리자님 어서오십쇼!!!!!!!!!!!!</b><p></p>
			<input type="button" value="상품정보 수정하기">
			<input type="button" value="상품정보 삭제하기">
	<%
		} /*else if문 닫기*/ else{
	%>
			<h2>[system] 회원으로 로그인하였습니다.</h2>
			<p>🎉환영합니다. <%=id %>님!🎉</p>
	<%
		} /*else문 닫기*/
	%>
	
</body>
</html>