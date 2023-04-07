package servletAPI.exdb;

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
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	//생성자
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
			
		} catch (Exception e) {
			System.out.println("커넥션풀 연결 실패");
			e.printStackTrace();
		}
	}
	
	//메서드
	//회원 목록 확인 메서드
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			con = dataFactory.getConnection();
			String query = "select * from membertbl order by joinDate";	
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
			e.printStackTrace();
		}
		return list;
	}
	
	//회원 등록 메서드
	public void addMember(MemberVO memVo) {
		//예기치 않은 일은 항상 발생할 수 있다. 예외처리 필수!
		try {
			//DataSource를 이용해 데이터베이스와 연결
			con = dataFactory.getConnection();
			String id = memVo.getId();
			String pwd = memVo.getPwd();
			String name = memVo.getName();
			String email = memVo.getEmail();

			String query="insert into membertbl(id, pwd, name, email) values(?, ?, ?, ?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			//회원정보 테이블에 추가기능을 실행
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println("등록 중 오류 발생");
			e.printStackTrace();
		}
	}
	
	//회원 삭제 메서드
	public void delMember(String id) {
		try {
			con = dataFactory.getConnection();
			String query = "delete from membertbl where id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			//삭제 쿼리 명령 실행
			pstmt.executeUpdate();
			//문 잘 닫아주기
			pstmt.close();
		} catch (Exception e) {
			System.out.println("삭제 중 오류 발생");
			e.printStackTrace();
		}
	}
}
