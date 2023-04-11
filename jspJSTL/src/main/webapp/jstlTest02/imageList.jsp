<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록 리스트</title>
</head>
<body>
	<h2 align="center">😎Core태그 라이브러리😎</h2>
	<h3 align="center">ㅡ상품 목록 리스트ㅡ</h3>
	<hr>
	<table border="3" align="center" width="600">
		<tr align="center" bgcolor="lightyellow">
			<th>상품이미지</th><th>상품이름</th><th>선택하기</th>
		</tr>
		<c:forEach var="i" begin="1" end="5" step="1">
			<tr align="center">
				<td width="200"><img alt="product0${i}" src="../images/product0${i}.png" width="200"></td>
				<td width="200">이미지 이름 : SolarSystem_${i}</td>
				<td width="200"><input name="chk${i}" type="checkbox"></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>