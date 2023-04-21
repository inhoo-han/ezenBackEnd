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
				"ORDER SIBLINGS BY articleNo desc";
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
	//      ↓여기변경
	public int insertNewArticle(ArticleVO articleVO) {
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
		return articleNo;
	}
	
	//선택한 글 상세 내용 메서드
	public ArticleVO selectArticle(int articleNo) {
		ArticleVO article = new ArticleVO();
		try {
			conn = dataFactory.getConnection();
			String query = "select articleNo, parentNo, title, content, NVL(imageFileName, 'null') as imageFileName, "
					+ " id, writeDate from boardtbl where articleNo=?";
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, articleNo);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int _articleNo = rs.getInt("articleNo");
			int parentNo = rs.getInt("parentNo");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String imageFileName = URLEncoder.encode(rs.getString("imageFileName"), "utf-8");
			if(imageFileName.equals("null")) {
				imageFileName = null;
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
	
	//글 수정하기 메서드
	public void updateArticle(ArticleVO article) {
		int articleNo = article.getArticleNo();
		String title = article.getTitle();
		String content = article.getContent();
		String imageFileName = article.getImageFileName();
		try {
			conn = dataFactory.getConnection();
			String query = "update boardtbl set title=?, content=?";
			if(imageFileName != null && imageFileName.length() != 0) {
				query += ", imageFileName=? ";
				
			}
			query += " where articleNo=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			//이미지가 있으면 이미지가 세 번째 물음표, 없으면 articleNo가 세 번째
			if(imageFileName != null && imageFileName.length() != 0) {
				pstmt.setString(3, imageFileName);
				pstmt.setInt(4, articleNo);
			}else {
				pstmt.setInt(3, articleNo);
			}
			pstmt.executeUpdate();
			pstmt.close();
			conn.close(); 
		} catch (Exception e) {
			System.out.println("☹BoardDAO -글 수정 중 에러 발생☹");
			e.printStackTrace();
		}
	}
	
	//삭제하기 전 삭제할 글번호 목록 가져오기
	public List<Integer> selectRemovedArticles(int articleNo){
		List<Integer> articleNoList = new ArrayList<Integer>();
		try {
			conn = dataFactory.getConnection();
			String query = "select articleNo from boardtbl START WITH articleNo=? "
					+ "CONNECT BY PRIOR articleNo=parentNo";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNo);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				articleNo = rs.getInt("articleNo");
				articleNoList.add(articleNo);
			}
			pstmt.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("☹BoardDAO - 삭제할 글 번호 목록 가져오는 중 에러 발생☹");
			e.printStackTrace();
		}
		return articleNoList;
	}
	
	//진짜로 삭제하기
	public void deleteArticle(int articleNo) {
		try {
			conn = dataFactory.getConnection();
			String query = "delete from boardtbl where articleNo in "
					+ "(select articleNo from boardtbl START WITH articleNo=? "
					+ "CONNECT BY articleNo=parentNo)";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNo);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("☹BoardDAO - 글 삭제 중 에러 발생☹");
			e.printStackTrace();
		}
	}
}
