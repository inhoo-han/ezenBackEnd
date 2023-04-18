package memberMVC.board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	//[필드]
	private Connection conn;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	//[생성자]
	public BoardDAO() {
		try {
			/*JNDI(Java Naming and Directory Interface)에
			 * 접근하기 위해 기본 경로(java:/comp/env)를 지정
			 * (자바 애플리케이션을 외부 디렉터리 서비스에 연결
			 */
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
			
		} catch (Exception e) {
			System.out.println("오라클 연결 실패");
			e.printStackTrace();
		}
	}
	
	//[메서드]
	//글 목록 보기 메서드
	public List<ArticleVO> selectAllArticles(){
		List<ArticleVO> articleList = new ArrayList<>();
		try {
			conn = dataFactory.getConnection();
			String query = "select LEVEL, articleNo, parentNo, title, content, writeDate, " + 
				"id from boardtbl START WITH parentNo = 0 CONNECT BY PRIOR articleNo = parentNo " +
				"ORDER SIBLINGS BY articleNo";
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();	//조회하는 ResultSet
			while(rs.next()) {
				//계층형 글의 깊이를 나타내는 level 속성
				int level = rs.getInt("level");
				int articleNo = rs.getInt("articleNo");
				int parentNo = rs.getInt("parentNo");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date writeDate = rs.getDate("writeDate");
				String id = rs.getString("id");
				
				ArticleVO articleVO = new ArticleVO();
				articleVO.setLevel(level);
				articleVO.setArticleNo(articleNo);
				articleVO.setParentNo(parentNo);
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setWriteDate(writeDate);
				articleVO.setId(id);
				
				articleList.add(articleVO);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("☹글 목록 처리 중 에러 발생☹");
			e.printStackTrace();
		}
		return articleList;
	}
}
