<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String msg = "👀아이디를 입력하지 않았습니다.<br>아이디를 입력해 주세요.👀";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과창</title>
</head>
<body>
	<%
		String id = request.getParameter("user_id");
		if(id.length() == 0 || id == null){
			/*이전 방법
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);*/
			/*액션 태그 이용하는 방법*/
	%>
		<jsp:forward page="login.jsp">
			<jsp:param value="<%=msg %>" name="msg"/>
		</jsp:forward>
	<%
		}
	%>
		<h2>😊<%=id %>님 환영합니다😊</h2>
</body>
</html>