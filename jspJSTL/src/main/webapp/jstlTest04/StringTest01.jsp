<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문자 태그</title>
</head>
<body bgcolor="#eee">
	<h2 align="center">😎Functions태그 라이브러리😎</h2>
	<h3 align="center">ㅡ문자(String)에 관련된 태그ㅡ</h3>
	<h3 align="center"><i>[fn:indexOf()]</i></h3>
	<hr>
	<h4 align="center">
	<c:set var="word" value="cOmpUtEr" />
	<c:set var="str" value="mp" />
	해당 문자열 : ${word}<br>
	문자열의 길이 : ${fn:length(word)}<br>
	전부 대문자로 : ${fn:toUpperCase(word)}<br>
	전부 소문자로 : ${fn:toLowerCase(word)}<br>
	일부 문자만 추출 \${fn:substring(word,3,6)} : ${fn:substring(word,3,6)}<br>
	문자의 위치 \${fn:indexOf(word,str)} : ${fn:indexOf(word,str)}<br>
	대체하기 \${fn:replace(word, "O", "Q")} : ${fn:replace(word, "O", "Q")}<br>
	문자 찾기 \${fn:contains(word,str)} : ${fn:contains(word,str)}<br>
	</h4>
</body>
</html>