package memberMVC.member;

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
	private Connection conn;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	//생성자
	public MemberDAO() {
		try {
			/*JNDI(Java Naming and Directory Interface)에
			 * 접근하기 위해 기본 경로(java:/comp/env)를 지정
			 * (자바 애플리케이션을 외부 디렉터리 서비스에 연결
			 */
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
			
		} catch (Exception e) {
			System.out.println("커넥션풀 연결 실패");
			e.printStackTrace();
		}
	}
	
	//[메서드]
	//회원 목록 조회 메서드
	public List<MemberVO> listMembers() {
		List<MemberVO> memberList = new ArrayList();
		try {
			conn = dataFactory.getConnection();
			String query = "select * from membertbl order by joinDate desc";
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO memberVO = new MemberVO(id, pwd, name, email, joinDate);
				memberList.add(memberVO);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("DB조회 중 에러!!");
			e.printStackTrace();
		}
		return memberList;
		
	}
}
