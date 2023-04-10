package servletdb.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	//driver변수 : 오라클 드라이버를 연결한다. 
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	//sql dev에서 만든 url
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	//sql dev에서 만든 유저 계정 이름
	private static final String user = "userjsp";
	//sql dev에서 만든 유저 계정 비밀번호
	private static final String pwd = "1234";
	//db연결하는 클래스
	private Connection con;
	//쿼리문 사용하기 위해. Statement import할 때 sql로 잘 선택하기.
	private Statement stmt;
	
	//메서드
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			connDB();
			String query = "select * from membertbl";	
			//stmt.executeQuery : 쿼리문 실행할 때 누르는 초록 화살표같은 역할을 한다. 
			//Resultset : 마치 커서처럼 나온 자료를 한 줄씩 알려준다. 
			ResultSet rs = stmt.executeQuery(query);
			//rs는 맨 처음에 (헤더)위치에 있다가 next()를 받아 그 뒤로 1, 2, 3,...으로 넘어간다.
			while(rs.next()) {
				//varchar2였기 때문에 getString으로 받음. 숫자일 때는 getInt, getFloat이렇게 받는다. 
				//                        ↓컬럼 이름을 넣거나 컬럼 index번호를 넣어도 된다. id = 0번
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				//위의 값을 가져와 보관할 때 사용하는 MemberVO
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			//자료를 열었으면 반드시 닫아야한다.
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("테이블 자료 오류 => " + e.getMessage());
		}
		return list;
	}
	
	//DB연결
	private void connDB() {
		try {
			//드라이버 이름을 가져온
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");
			//만든 데이터베이스(membertbl)를 stmt로 불러온다.
			stmt = con.createStatement();
			System.out.println("Statement 생성 성공");
		} catch (Exception e) {
			//연결이 안 되면 오류메세지가 뜬다. 보고 이해할 수 있으면 고치고, 안 되면 선생님께 여쭤보자.
			System.out.println("연결오류 => " + e.getMessage());
		}
	}
}
