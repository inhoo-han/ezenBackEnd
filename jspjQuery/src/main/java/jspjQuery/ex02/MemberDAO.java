package jspjQuery.ex02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	
	//ID 중복 체크(DB활용)
	//false: 쓸 수 있는 ID, true: 쓸 수 없는 ID
	public boolean overlappedID(String id) {
		boolean result=false;
		//중복 체크
		try {
			con=dataFactory.getConnection();
			String query="select decode(count(*),1,'true','false') as result"
					+ " from membertbl where id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			//뮨자로 된 true, false를 진짜 불린값으로 변경해 주는 과정
			result = Boolean.parseBoolean(rs.getString("result")); //result : 쿼리문 별칭
			//잘 닫아라
			pstmt.close();
		}catch (Exception e) {
			System.out.println("DB에서 ID 중복 체크 처리 중 에러!!");
			e.printStackTrace();
		}
		return result;
	}
}
