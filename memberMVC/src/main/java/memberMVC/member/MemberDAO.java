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
	
	//회원 등록 메서드
	public void addMember(MemberVO memberVO) {
		try {
			conn = dataFactory.getConnection();
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			String query = "insert into membertbl (id,pwd,name,email) values(?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			System.out.println("DB등록 중 에러!!");
			e.printStackTrace();
		}
	}
	
	//수정할 회원정보 찾기 메서드
	public MemberVO findMember(String _id) {
		MemberVO memFindInfo = null;
		try {
			conn = dataFactory.getConnection();
			String query = "select * from membertbl where id=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, _id);
			ResultSet rs = pstmt.executeQuery();
			//자료 헤더에서 1번자료로 넘어오기 위한 .next()
			rs.next();
			String id = rs.getString("id");			//수정X
			String pwd = rs.getString("pwd");		//수정O
			String name = rs.getString("name");		//수정O
			String email = rs.getString("email");	//수정O
			Date joinDate = rs.getDate("joinDate");	//수정X
			
			memFindInfo = new MemberVO(id, pwd, name, email, joinDate);
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("회원정보 찾는 중 오류");
			e.printStackTrace();
		}
		return memFindInfo;
	}
	
	//회원 정보 수정하기 메서드
	public void modMember(MemberVO memberVO) {
		String id = memberVO.getId();
		String pwd = memberVO.getPwd();
		String name = memberVO.getName();
		String email = memberVO.getEmail();
		try {
			conn = dataFactory.getConnection();
			String query = "update membertbl set pwd=?, name=?, email=? where id=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pwd);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, id);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("회원정보 수정 중 에러");
			e.printStackTrace();
		}
	}
	
	//회원 삭제 메서드
	public void delMember(String _id) {
		try {
			conn = dataFactory.getConnection();
			String query = "delete from membertbl where id=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, _id);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("회원 삭제 중 오류");
			e.printStackTrace();
		}
	}
}
