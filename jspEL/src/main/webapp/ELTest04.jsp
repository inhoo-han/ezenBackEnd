<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
    <!-- isELIgnored="true"이면 표현언어를 무시한다는 뜻이므로 false를 해야 표현언어 사용 가능 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현언어</title>
</head>
<body bgcolor="#eee">
	<h2>📰표현언어의 논리연산자📰</h2>
	<h3>
		<&&, and연산자><br>
		👀\${30 == 30 && 20 == 20} = ${30 == 30 && 20 == 20}<br>
		👀\${30 == 30 and 20 == 20} = ${30 == 30 and 20 == 20}<br>
		<br><||, or연산자><br>
		👀\${30 == 30 || 20 == 20} = ${30 == 30 || 20 == 20}<br>
		👀\${30 == 30 or 20 == 20} = ${30 == 30 or 20 == 20}<br>
		<br><!, not연산자><br>
		👀\${!(30 == 80)} = ${!(30 == 80)}<br>
		👀\${not(30 == 80)} = ${not(30 == 80)}<br>
	</h3>
</body>
</html>