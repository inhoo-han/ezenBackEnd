<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	int score = Integer.parseInt(request.getParameter("score"));
%>
<%! String grade; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor='#f0ffda'>
	<h2 style="color:#004e22;">시험 결과</h2>
	<hr>
	<p>✔이름 : <%=name %> </p>

	<%
		if(score >= 90 && score <= 100) {
			grade = "A";
		}else if(score >= 80) {
			grade = "B";
		}else if(score >= 70) {
			grade = "C";
		}else if(score >= 60) {
			grade = "D";
		}else{
			grade = "F";
		}
	%>
	
	<p>✔점수 : <%=score %>점</p>
	<p>✔등급 : <%=grade %>등급입니다.</p>
	<a href="scoreTest.html">시험점수 다시입력</a>
</body>
</html>