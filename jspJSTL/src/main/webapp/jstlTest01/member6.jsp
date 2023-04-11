<%-- JSTL 학습 중 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, jspJSTL.ex01.*"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
	List memberList = new ArrayList();
	MemberBean mem1 = new MemberBean("baek-ho", "1031", "강백호", "baek-ho@slam.dunk");
	MemberBean mem2 = new MemberBean("tjxodnd", "0101", "서태웅", "tjxodnd@slam.dunk");
	MemberBean mem3 = new MemberBean("txx_sub", "7777", "송태섭", "txx_sub@slam.dunk");
	MemberBean mem4 = new MemberBean("big10000", "0522", "정대만", "big10000@slam.dunk");
	MemberBean mem5 = new MemberBean("chisuChae", "4444", "채치수", "chisuChae@slam.dunk");
	memberList.add(mem1);
	memberList.add(mem2);
	memberList.add(mem3);
	memberList.add(mem4);
	memberList.add(mem5);
%>
<c:set var="mlist" value="<%=memberList %>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Core태그 라이브러리</title>
</head>
<body bgcolor="#eee">
	<h2 align="center">😎Core태그 라이브러리😎</h2>
	<h3 align="center">ㅡc:forEach태그 + MemberBean 이용해보기ㅡ</h3>
	<!-- <h3 align="center"><i>items속성</i></h3> -->
	<hr>
	<table border="3" align="center" width="700">
		<tr align="center" bgcolor="#ffad98">
			<th>아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th>
		</tr>
		<c:forEach var="i" begin="0" end="4" step="1">
			<tr>
				<td>${mlist[i].id}</td>
				<td>${mlist[i].pwd}</td>
				<td>${mlist[i].name}</td>
				<td>${mlist[i].email}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>