package jsp01.ex02;

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
	public List<MemberVO> listMembers(MemberVO memVO){
		List list = new ArrayList();
		String _name = memVO.getName();
		try {
			con = dataFactory.getConnection();
			String query = "select * from membertbl order by joinDate";	
			//↓여기 변경
			if(_name != null && _name.length() != 0) {
				//한 칸 더 띄우는 것 동의
				query += " where name=";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1,  _name);
			}else {
				pstmt = con.prepareStatement(query);
			}
			//↑여기 변경
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
}
