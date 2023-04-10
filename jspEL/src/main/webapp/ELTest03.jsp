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
	<h2>📰표현언어의 비교연산자📰</h2>
	<h3>
		<일치 비교><br>
		👀\${30 == 30} = ${30==30}<br>
		👀\${30 eq 30} = ${30 eq 30}<br>
		<br><문자의 일치 비교><br>
		👀\${"bbang" == "bbang"} = ${"bbang" == "bbang"}<br>
		👀\${"bbang" eq "bbang"} = ${"bbang" eq "bbang"}<br>
		<br><같지 않은지 비교><br>
		👀\${30 != 30} = ${30 != 30}<br>
		👀\${30 ne 30} = ${30 ne 30}<br>
		<br><크기비교><br>
		👀\${30 > 20} = ${30 > 20}<br>
		👀\${30 gt 20} = ${30 gt 20}<br>
		👀\${30 < 20} = ${30 < 20}<br>
		👀\${30 lt 20} = ${30 lt 20}<br>
		👀\${30 >= 20} = ${30 >= 20}<br>
		👀\${30 ge 20} = ${30 ge 20}<br>
		👀\${30 <= 20} = ${30 <= 20}<br>
		👀\${30 le 20} = ${30 le 20}<br>
	</h3>
</body>
</html>