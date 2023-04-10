<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    import="java.util.*, jspEL.ex01.*"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="memBean" class="jspEL.ex01.MemberBean"/>
<jsp:setProperty property="*" name="memBean"/>
<jsp:useBean id="memberList" class="java.util.ArrayList"/>
<%
	memberList.add(memBean);
	MemberBean memBean2 = new MemberBean("baek-ho","1031","강백호","baek-ho0401@slamdunk.com");
	memberList.add(memBean2);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useBean을 이용하여 ArrayList에 값 넣기</title>
</head>
<body>
	<h2 align="center">😎useBean을 이용하여 ArrayList에 값 넣기😎</h2>
	<table border="3" align="center">
		<tr align="center" bgcolor="lightyellow">
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
		</tr>
		<!-- 외부에서 받아온 값 -->
		<tr>
			<td>${memberList[0].id}</td>
			<td>${memberList[0].pwd}</td>
			<td>${memberList[0].name}</td>
			<td>${memberList[0].email}</td>
		</tr>
		<!-- 위에서 내가 직접 작성해 넣은 값 -->
		<tr>
			<td>${memberList[1].id}</td>
			<td>${memberList[1].pwd}</td>
			<td>${memberList[1].name}</td>
			<td>${memberList[1].email}</td>
		</tr>
	</table>
</body>
</html>