<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험 결과 출력 페이지</title>
</head>
<body>
	<h2 align="center">😎Core태그 라이브러리 - 문제😎</h2>
	<h3 align="center">ㅡc:choose태그 이용하여 시험 결과 출력하기ㅡ</h3>
	<hr>
	<c:set var="score" value="${param.score}" />
	<%-- [0]시험점수에 외의 것이 들어와 에러나는 것 방지하기 --%>
	<%-- catch의 변수e에는 오류가 있다면 오류 내용이 들어간다. --%>
	<c:catch var="e">
		<p style="display:none;">${score = score*1}</p>
	</c:catch>
	<%-- 시험점수에 숫자 외의 것이 들어왔을 때 --%>
	<c:if test="${e != null}">
		<h4 align="center">👀점수를 잘못 입력하였습니다. 다시 입력해주세요👀</h4>
		<a align="center" href="scoreTest.jsp">점수 입력창으로 이동</a>
	</c:if>
	<%-- 시험점수에 숫자가 잘 들어와 오류가 없을 때 --%>
	<c:if test="${e == null}">
		<c:choose>
			<%-- [1]점수가 0~100사이에 잘 들어왔을 경우 --%>
			<c:when test="${not empty param.score && param.score >= 0 && param.score <= 100}">
				<h4 align="center">👀${param.name}님의 시험점수는 ${param.score}점이고👀</h4>
				<c:choose>
					<%-- [1-1]A학점 --%>
					<c:when test="${param.score >= 90}">
						<h4 align="center">A학점입니다.</h4>
					</c:when>
					<%-- [1-2]B학점 --%>
					<c:when test="${param.score >= 80 && param.score < 90}">
						<h4 align="center">B학점입니다.</h4>
					</c:when>
					<%-- [1-3]C학점 --%>
					<c:when test="${param.score >= 70 && param.score < 80}">
						<h4 align="center">C학점입니다.</h4>
					</c:when>
					<%-- [1-4]D학점 --%>
					<c:when test="${param.score >= 60 && param.score < 70}">
						<h4 align="center">D학점입니다.</h4>
					</c:when>
					<%-- [1-5]F학점 --%>
					<c:when test="${param.score < 60}">
						<h4 align="center">F학점입니다.</h4>
					</c:when>
				</c:choose>
			</c:when>
			<%-- [2]점수가 0~100사이에 들어오지 않은 경우 --%>
			<c:otherwise>
				<h4 align="center">👀점수를 잘못 입력하였습니다. 다시 입력해주세요👀</h4>
				<a align="center" href="scoreTest.jsp">점수 입력창으로 이동</a>
			</c:otherwise>
		</c:choose>
	</c:if>
</body>
</html>