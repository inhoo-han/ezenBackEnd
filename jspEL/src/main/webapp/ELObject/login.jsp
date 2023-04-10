<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 창</title>
</head>
<body bgcolor="#BEAEE2">
	<form action="result.jsp" method="post">
		이름 : <input type="text" name="user_id"><br>
		비밀번호 : <input type="password" name="user_pw"><br>
		<input type="submit" value="로그인">
		<input type="reset" value="다시입력">
	</form>
	<!-- 회원가입하기 추가 : 표현식 -->
	<%-- <a href="<%=request.getContextPath() %>/ELObject/memberForm.html">회원가입하기</a> --%>
	<!-- 회원가입하기 추가 : 표현언어 -->
	<a href="${pageContext.request.contextPath}/ELObject/memberForm.html">회원가입하기</a>
</body>
</html>