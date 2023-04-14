package forChoRong.ex01;

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
	//메시지 목록 확인 메서드
	public List listMessage(){
		List list = new ArrayList();
		try {
			con = dataFactory.getConnection();
			String query = "select * from guestbooktbl order by num desc";	
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				String pwd = rs.getString("pwd");
				String message = rs.getString("message");
				int num = rs.getInt("num");
				MemberBean vo = new MemberBean();
				vo.setName(name);
				vo.setPwd(pwd);
				vo.setMessage(message);
				vo.setNum(num);
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
	
	//↓여기 변경
	//메시지 등록 메서드
	public void addMessage(MemberBean memVo) {
		//예기치 않은 일은 항상 발생할 수 있다. 예외처리 필수!
		try {
			//DataSource를 이용해 데이터베이스와 연결
			con = dataFactory.getConnection();
			String name = memVo.getName();
			String pwd = memVo.getPwd();
			String message = memVo.getMessage();
			//만약 기본 Statement를 사용했다면 아래와 같이 코딩했어야 했다.
//			String query="insert into membertbl(id, pwd, name, email) "
//					+ "values('" + id + "', '" + pwd + "', '" + name + "', '" + email + "')";
			
			//PreparedStatement를 사용해서 아래처럼 바뀐다.
			//직접 값을 집어넣지 않고, 자료의 개수만큼 물음표를 이용해 사용한다.
			String query="insert into guestbooktbl(name, pwd, message) values(?, ?, ?)";
			pstmt = con.prepareStatement(query);
			//받는 값이 전부 문자라서 setString임. setInt, setDouble등도 있음.
			//첫번째 ?에 들어갈 내용이 id이다.
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			pstmt.setString(3, message);
			//회원정보 테이블에 추가기능을 실행
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println("등록 중 오류 발생");
			e.printStackTrace();
		}
	}
}
