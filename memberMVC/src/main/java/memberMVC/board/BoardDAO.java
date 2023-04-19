package memberMVC.board;

import java.net.URLEncoder;
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
			System.out.println("BoardDAO - 오라클 연결 실패");
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
			System.out.println("☹BoardDAO - 글 목록 처리 중 에러 발생☹");
			e.printStackTrace();
		}
		return articleList;
	}
	
	//글 번호 생성 메서드
	private int getNewArticleNo() {
		int aNo = 1;
		try {
			conn = dataFactory.getConnection();
			//max함수를 이용하여 기존 articleNo중 가장 큰 값을 가져온다
			String query = "select max(articleNo) from boardtbl";
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				aNo = rs.getInt(1)+1;
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("☹BoardDAO - 글 번호 생성 중 에러 발생☹");
			e.printStackTrace();
		}
		return aNo;
	}
	
	
	//새 글 추가 메서드
	public void insertNewArticle(ArticleVO articleVO) {
		int articleNo = getNewArticleNo();
		try {
			conn = dataFactory.getConnection();
			int parentNo = articleVO.getParentNo();
			String title = articleVO.getTitle();
			String content = articleVO.getContent();
			String imageFileName = articleVO.getImageFileName();
			String id = articleVO.getId();
			String query = "insert into boardtbl (articleNo, parentNo, title, content, imageFileName, id) values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNo);
			pstmt.setInt(2, parentNo);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
			pstmt.setString(5, imageFileName);
			pstmt.setString(6, id);
			
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("☹BoardDAO - 테이블 추가 중 에러 발생☹");
			e.printStackTrace();
		}
	}
	
	//선택한 글 상세 내용 메서드
	public ArticleVO selectArticle(int articleNo) {
		ArticleVO article = new ArticleVO();
		try {
			conn = dataFactory.getConnection();
			String query = "select articleNo, parentNo, title, content, imageFileName"
					+ " id, writeDate from boardtbl where articleNo=?";
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, articleNo);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int _articleNo = rs.getInt("articleNo");
			int parentNo = rs.getInt("parentNo");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String imageFileName = rs.getString("imageFileName");
			if(imageFileName != null) {
				imageFileName = URLEncoder.encode(rs.getString("imageFileName"), "utf-8");
			}
			String id = rs.getString("id");
			Date writeDate = rs.getDate("writeDate");
			
			article.setArticleNo(_articleNo);
			article.setParentNo(parentNo);
			article.setTitle(title);
			article.setContent(content);
			article.setImageFileName(imageFileName);
			article.setId(id);
			article.setWriteDate(writeDate);
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("☹BoardDAO - 상세 글을 불러오는 중 에러 발생☹");
			e.printStackTrace();
		}
		return article;
	}
}