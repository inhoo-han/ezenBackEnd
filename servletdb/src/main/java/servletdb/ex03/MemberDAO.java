package servletdb.ex03;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	//필드
  	//삭제된 내용 : 디비 연결되는 부분
	private Connection con;
	private PreparedStatement pstmt;
	//↓여기 변경
	private DataSource dataFactory;
	
	//↓여기 변경
	//생성자
	public MemberDAO() {
		try {
			//JNDI에 접근하기 위해 기본 경로(java:/comp/env)를 지정
			Context ctx = new InitialContext();
			//기본 경로가 Object타입이기 때문에 Context타입으로 형변환 필요하다.
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			//DataSource타입으로 형변환 필요하다. (원래는 무슨 타입일까?)
			//톰캣 context.xml에 설정한 name값인 jdbc/oracle을 이용해 톰캣에 미리 연결한 DataSource를 받아온다.
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
			
		} catch (Exception e) {
			System.out.println("커넥션풀 연결 실패");
		}
	}
	
	//메서드
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			//DataSource를 이용해 데이터베이스를 연결
			con = dataFactory.getConnection();
			String query = "select * from membertbl";	
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			//자료 닫기
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("테이블 자료 오류 => " + e.getMessage());
		}
		return list;
	}
	
	//삭제된 내용 : 디비 연결
}
