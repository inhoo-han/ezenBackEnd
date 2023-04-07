<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int dan = Integer.parseInt(request.getParameter("dan"));
%>
<%! String print = ""; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 정답</title>
</head>
<body bgcolor='#f0ffda'>
	<% print=""; %>
	<h2 style="color:#004e22;">구구단을 외자</h2>
	<hr>
	<p><b>✔출력하고 싶은 단수 : <%=dan %> </b></p>
	<%
		for(int i = 1; i < 10; i++){
			print += dan + " X " + i + " = " + (dan*i) + "<br>";
		}
	%>
	<%=print %>
	<a href="gugu.html"><br>구구단 다시 계산하기</a>
</body>
</html>