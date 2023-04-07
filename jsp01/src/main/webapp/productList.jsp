<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품정보리스트</title>
<style type="text/css">
	*{
		list-style: none;
	}
	body{
		background-color: #000;
	}
	.list{
		width: 80%;
		padding: 0 10px 10px 0;
		margin: 0 auto;
		overflow: hidden;
	}
	.list li{
		position: relative;
		margin: 10px 0 0;
		overflow: hidden;
		clear: both;
		color: #2d2d2d;
		line-height: 200px;
		border-bottom: 2px solid #ccc;
	}
	.pimg{
		margin-left: 50px;
	}
	.list li img{
		position: absolute;
		float: left;
	}
	.list li a{
		color: #eee;
		text-decoration: none;
		margin-left: 360px;
		font-size: 30px;
	}
	.list li a:hover{
		color: #fff8b2;
	}
	.list li span{
		color: #e3fdc8;
		margin-left: 330px;
		font-size: 30px;
	}
</style>
</head>
<body>
	<ul class="list">
		<li>
			<span class="pimg">상품이미지</span>
			<span>상품명</span>
			<span>상품선택</span>
		</li>
		<%
			String[] pName = {"태양","지구","목성","토성","천왕성"};
			for(int i=0; i<5; i++) {
		%>
				<li>
					<a class="pimg" href="#">
						<img src="images/product0<%=(i+1) %>.png" alt="" width="200px">
					</a>
					<a href="#"><strong><%=pName[i] %></strong></a>
					<a href="#"><input type="checkbox" name="chk<%=i+1 %>"></a>
				</li>	
		<%
			}
		%>
	</ul>
</body>
</html>