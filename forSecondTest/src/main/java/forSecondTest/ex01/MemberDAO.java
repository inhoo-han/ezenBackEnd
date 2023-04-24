package forSecondTest.ex01;

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
				String name = rs.getString("name");
				String email = rs.getString("email");
				String pass = rs.getString("pass");
				String telecom = rs.getString("telecom");
				int telno = rs.getInt("telno");
				MemberVO memberVO = new MemberVO(name, email, pass, telecom, telno);
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
	
	//회원 등록 메서드
	public void addMember(MemberVO memberVO) {
		try {
			conn = dataFactory.getConnection();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			String pass = memberVO.getPass();
			String telecom = memberVO.getTelecom();
			int telno = memberVO.getTelno();
			String query = "insert into test1tbl (name,email,pass,telecom,telno) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, pass);
			pstmt.setString(4, telecom);
			pstmt.setInt(5, telno);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			System.out.println("DB등록 중 에러!!");
			e.printStackTrace();
		}
	}
	
	//회원 찾는 메서드
	public String loginMember(MemberVO memberVO) {
		Boolean result = false;
		String msg = null;
		String name = null;
		try {
			conn = dataFactory.getConnection();
			String email = memberVO.getEmail();
			String pass = memberVO.getPass();
			System.out.println("email : " + email);
			System.out.println("pass : " + pass);
			
			String query = "select name from test1tbl where email = (select email from test1tbl where email=? and pass=?)";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			name = rs.getString("name");
			System.out.println(name);
			System.out.println("찾앗서");
			msg = (name + "님 환영합니다.");
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			msg = "일치하는 정보가 없습니다.";
			System.out.println("멤버 찾는 도중 에러!!");
			e.printStackTrace();
		}
		return msg;
	}
	
}
