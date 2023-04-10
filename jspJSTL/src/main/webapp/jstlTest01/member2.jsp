<%-- JSTL 학습 중 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    isELIgnored="false"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="memMap" class="java.util.HashMap"/>
<%
	memMap.put("id","baek-ho");
	memMap.put("pwd","1031");
	memMap.put("name","강백호");
	memMap.put("address","파주시 운정동");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Core태그 라이브러리</title>
</head>
<body>
	<h2 align="center">😎Core태그 라이브러리😎</h2>
	<h3 align="center">ㅡHashMap 이용ㅡ</h3>
	<table border="3" align="center">
		<tr align="center" bgcolor="#BEAEE2">
			<th>아이디</th><th>비밀번호</th><th>이름</th><th>주소</th>
		</tr>
		<tr>
			<td>${memMap.id}</td>
			<td>${memMap.pwd}</td>
			<td>${memMap.name}</td>
			<td>${memMap.address}</td>
		</tr>
	</table>
</body>
</html>