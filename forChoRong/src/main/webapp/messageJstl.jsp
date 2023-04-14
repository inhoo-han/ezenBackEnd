<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>초롱이를 향한 메시지들</title>
<link href="https://webfontworld.github.io/PyeongChang/PyeongChangPeace.css" rel="stylesheet">
<style>
*{
	margin: 0;
	padding: 0;
	font-family: 'PyeongChangPeace';
	text-decoration: none;
	box-sizing: border-box;
	color: #333;
}
body{
	background: fff8b2;
	font-family: 'PyeongChangPeace';
}
h1{
	margin: 20px;
	font-size: 80px;
}
h3{
	margin-bottom: 50px;
	font-size: 40px;
}
table, td, tr{
	display: inline-block;
	margin: 0px auto;
	line-height: 50px;
	font-family: 'PyeongChangPeace';
	font-weight: bold;
	color: #333;
}
table{
	width: 500px;
	background: #fff;
	border: 3px solid lightpink;
	border-radius: 20px;
	margin-top: 50px;
}
.title{
	margin: 20px auto;
	border: none;
	border-radius: 20px;
	text-align: center;
	font-size: 30px;
	background: lightpink;
}
.title th{
	text-align: center;
	border: none;
}
.title .name{
	width: 150px;
}
.title .message{
	width: 320px;
}
tr{
	margin: 5px 0;
}
td.name{
	width: 150px;
	border: none;
}
td.message{
	width: 320px;
	height: auto;
	border: 1px solid #ccc;
	border-radius: 10px;
	padding: 5px;
	white-space: normal;
	text-align: left;
	word-break: keep-all;
}
</style>
</head>
<body align="center" bgcolor="#fff8b2">
	<h1>이초롱 생일 축하해</h1>
	<h3>🎉모두 초롱이의 생일을 축하해 주세요🎉</h3>
	<hr>
	<table align="center" border="3" width="600">
		<tr class="title">
			<th class="name">이름</th><th class="message">메시지</th>
		</tr>
		<c:forEach var="msg" items="${messageList}">
			<tr align="center">
				<td class="name">${msg.name}</td>
				<td class="message" style="word-break: break-all">${msg.message}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>