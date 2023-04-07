<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String print;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[내장객체] request실습 - submit(결과출력)</title>
</head>
<body>
	<%
		if(age>19){
			out.print("<h2>" + name + "님은 " + age + "세이므로 상품 구입이 가능합니다.😎😎</h2>");
		}else {
			out.print("<h2>" + name + "님은 " + age + "세이므로 더 커서 오세용.😝😝</h2>");
		}
	%>
</body>
</html>