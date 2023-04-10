<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    import="jspEL.ex01.*"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!-- New를 사용하지 않고 memberBean 클래스 객체를 생성. -->
<jsp:useBean id="memBean" class="jspEL.ex01.MemberBean"/>
<!-- setter쓰지 않고, property의 이름이 동일하다면 일치시켜준다. 짱편. -->
<jsp:setProperty property="*" name="memBean"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현식과 표현언어를 이용한 setter, getter</title>
</head>
<body>
	<h2 align="center">😎표현식과 표현언어를 이용한 setter, getter😎</h2>
	<table border="3" align="center">
		<tr align="center" bgcolor="lightyellow">
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
		</tr>
		<!-- getter를 통해 가져오기 -->
		<tr>
			<td><%=memBean.getId() %></td>
			<td><%=memBean.getPwd() %></td>
			<td><%=memBean.getName() %></td>
			<td><%=memBean.getEmail() %></td>
		</tr>
		<!-- getter도 안 써. 표현언어 쓸래. -->
		<tr>
			<td>${memBean.id}</td>
			<td>${memBean.pwd}</td>
			<td>${memBean.name}</td>
			<td>${memBean.email}</td>
		</tr>
	</table>
</body>
</html>