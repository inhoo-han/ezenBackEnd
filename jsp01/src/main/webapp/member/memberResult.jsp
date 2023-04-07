<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="jsp01.ex02.*"
    import="java.util.*" %>
<%
	request.setCharacterEncoding("utf-8");
	String _name = request.getParameter("name");
	MemberVO memVO = new MemberVO();
	memVO.setName(_name);
	MemberDAO dao = new MemberDAO();
	List memberList = dao.listMembers(memVO);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 출력창</title>
<style type="text/css">
	h1{
		text-align: center;
	}
</style>
</head>
<body>
	<h1>😎회원 정보 출력😎</h1>
	<table border="3" width="700" align="center">
		<tr align="center" bgcolor="#fff8b2">
			<th>아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th><th>가입일자</th>
		</tr>
		<%
			for(int i = 0; i<memberList.size(); i++){
				MemberVO vo=(MemberVO)memberList.get(i);
				String id = vo.getId();
				String pwd = vo.getPwd();
				String name = vo.getName();
				String email = vo.getEmail();
				Date joinDate = vo.getJoinDate();
		%>
		<tr align="center">
			<td><%=id %></td>
			<td><%=pwd %></td>
			<td><%=name %></td>
			<td><%=email %></td>
			<td><%=joinDate %></td>
		</tr>
		<%
			}/*for문 닫아주기*/
		%>
	</table>
</body>
</html>