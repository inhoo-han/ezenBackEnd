<%-- JSTL 학습 중 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    isELIgnored="false"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List dataList = new ArrayList();
	dataList.add("🌧오늘 비옵니다🌧");
	dataList.add("📆오늘은 수요일입니다📆");
	dataList.add("💙JSP배우는 중입니다💙");
%>
<!-- ↓이 방법은 사용이 불가능하다. 표현언어에는 동적배열이 값으로 넘어올 수 없다. -->
<!-- c:set var="list" value="${dataList}" /-->
<!-- ↓아래처럼 표현식으로 받아줘야 한다. -->
<c:set var="list" value="<%=dataList %>" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Core태그 라이브러리</title>
</head>
<body bgcolor="#eee">
	<h2 align="center">😎Core태그 라이브러리😎</h2>
	<h3 align="center">ㅡc:forToken태그 이용해보기ㅡ</h3>
	<!-- <h3 align="center"><i>items속성</i></h3> -->
	<hr>
	<c:set var="fruits" value="🍎사과🍎, 🍓딸기🍓, 🍌바나나🍌, 🍊오렌지🍊, 🍇포도🍇" />
	<c:forTokens var="token" items="${fruits}" delims= "," >
		<h4 align="center">💚과일 : ${token}</h4>
	</c:forTokens>
</body>
</html>