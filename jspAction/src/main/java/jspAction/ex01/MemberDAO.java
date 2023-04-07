package jspAction.ex01;

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
	//[필드]
	//DB와 연결해 주는 connection
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	//[생성자]
	public MemberDAO() {
		try {
			//context: 연결할 때 사용
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			//톰캣 컨테이너를 이용해 DB를 가져온다.
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			//↓이거 뜨면 서비스에서 OracleListener, OracleServer켜져있는지 봐야한다.
			System.out.println("오라클 연결에 실패하였습니다.");
		}
	}
	
	//[메서드]
	//회원 목록 확인 메서드
	public List listMembers() {
		//ArrayList: 동적배열(add로 추가하고 get으로 가져온다)
		List list = new ArrayList();
		try {
			con = dataFactory.getConnection();
			String query = "select * from membertbl order by joinDate desc";
			System.out.println("명령문 수행 결과: " + query);
			pstmt = con.prepareStatement(query);
			//ResultSet: 자료를 조회할 수 있게 커서를 가져다 놓아줌
			//executeQuery: 녹색 버튼 눌러 실행하듯이 실행시켜 줌
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				//vo: value object
				MemberBean vo = new MemberBean();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("조회 중 오라클 접속이 끊어졌습니다.");
			e.printStackTrace();
		}
		return list;
	}
	
	//회원 등록 메서드
	public void addMember(MemberBean vo) {
		try {
			con = dataFactory.getConnection();
			String id = vo.getId();
			String pwd = vo.getPwd();
			String name = vo.getName();
			String email = vo.getEmail();
			
			String query="insert into membertbl(id, pwd, name, email)"
					+ "values(?, ?, ?, ?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			//등록 실행
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			System.out.println("회원 등록 중 오류가 발생하였습니다.");
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
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			System.out.println("회원 삭제 중 오류가 발생하였습니다.");
			e.printStackTrace();
		}
	}
}
