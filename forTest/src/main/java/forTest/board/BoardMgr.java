package forTest.board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.spi.DirStateFactory.Result;
import javax.sql.DataSource;

public class BoardMgr {
	//[필드]
	private Connection conn;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	//[생성자]
	public BoardMgr() {
		try {
			/*JNDI(Java Naming and Directory Interface)에
			 * 접근하기 위해 기본 경로(java:/comp/env)를 지정
			 * (자바 애플리케이션을 외부 디렉터리 서비스에 연결
			 */
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
			
		} catch (Exception e) {
			System.out.println("😥BoardMgr - 오라클 연결 실패😥");
			e.printStackTrace();
		}
	}
	
	//[매서드]
	//글 목록보기 메서드
	public List<BoardBean> listOfBoard() {
		List<BoardBean> boardList = new ArrayList<>();
		try {
			conn = dataFactory.getConnection();
			String query = "select num, name, subject, content, regdate, pass, count from tblboard order by num desc";
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				Date regdate = rs.getDate("regdate");
				String pass = rs.getString("pass");
				int count = rs.getInt("count");
				
				BoardBean boardBean = new BoardBean();
				boardBean.setNum(num);
				boardBean.setName(name);
				boardBean.setSubject(subject);
				boardBean.setContent(content);
				boardBean.setRegdate(regdate);
				boardBean.setPass(pass);
				boardBean.setCount(count);
				
				boardList.add(boardBean);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("☹BoardMgr - 글 목록 처리 중 에러 발생☹");
			e.printStackTrace();
		}
		return boardList;
	}
	//글 상세보기 메서드
	public BoardBean viewOfBoard(int num) {
		BoardBean boardBean = new BoardBean();
		try {
			conn = dataFactory.getConnection();
			String query = "select num, name, subject, content, regdate, pass, count from tblboard where num=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int _num = rs.getInt("num");
			String name = rs.getString("name");
			String subject = rs.getString("subject");
			String content = rs.getString("content");
			Date regdate = rs.getDate("regdate");
			String pass = rs.getString("pass");
			int count = rs.getInt("count");
			
			boardBean.setNum(_num);
			boardBean.setName(name);
			boardBean.setSubject(subject);
			boardBean.setContent(content);
			boardBean.setRegdate(regdate);
			boardBean.setPass(pass);
			boardBean.setCount(count);
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("☹BoardMgr - 상세 글을 불러오는 중 에러 발생☹");
			e.printStackTrace();
		}
		return boardBean;
	}
	
	//글 수정하기 메서드
	
	//글 삭제하기 메서드
	public void delMember(int num) {
		try {
			conn = dataFactory.getConnection();
			String query = "delete from tblboard where num=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("회원 삭제 중 오류");
			e.printStackTrace();
		}
	}
}
