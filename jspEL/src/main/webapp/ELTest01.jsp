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
	<h2>📰표현언어로 여러가지 형태의 데이터 출력📰</h2>
	<h3>👀숫자값 = ${500}<br>
		👀홍길동님 ${"안녕하세요"}<br>
		👀홑/쌍따옴표 전부 인식 돼요<br>'홑따옴표' "쌍따옴표" ${'홑따옴표'} ${"쌍따옴표"}<br>
		👀연산 => ${20+50}<br>
		👀불린 => ${false}<br>
		👀실수값 => ${5.3}<br>
		👀연산 => "10" + 1 = ${"10" + 1}<br>
		👀문자+숫자연결 불가 => $ {"철수" + 20} => 오류<br>
		👀문자+문자연결 => $ {"철수" + "영희"} => 오류<br>
	</h3>
</body>
</html>