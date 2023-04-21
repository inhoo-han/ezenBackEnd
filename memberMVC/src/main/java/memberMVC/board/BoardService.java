package memberMVC.board;

import java.util.List;

public class BoardService {
	BoardDAO boardDAO;
	
	public BoardService() {
		//생성자에서 BoardDAO객체를 생성
		boardDAO = new BoardDAO();
	}
	
	//BoardController-매핑(/listArticles.do or null)
	public List<ArticleVO> listArticles(){
		List<ArticleVO> articleList = boardDAO.selectAllArticles();
		return articleList;
	}
	
	//BoardController-매핑(/addArticle.do)
	//      ↓여기변경 BoardDAO > insertNewArticle()
	public int addArticle(ArticleVO articleVO) {
		return boardDAO.insertNewArticle(articleVO);
	}
	
	//BoardController-매핑(/viewArticle.do)
	public ArticleVO viewArticle(int articleNo) {
		ArticleVO articleVO = null;
		articleVO = boardDAO.selectArticle(articleNo);
		return articleVO;
	}
	
	//BoardController-매핑(/modArticle.do)
	public void modArticle(ArticleVO articleVO) {
		boardDAO.updateArticle(articleVO);
	}
	
	//BoardController-매핑(/removeArticle.do)
	public List<Integer> removeArticle(int articleNo){
		//selectRemovedArticles: 부모에 대한 답글의 정보를 가져오는 역할
		List<Integer> articleNoList = boardDAO.selectRemovedArticles(articleNo);
		//deleteArticle: 삭제작업을 진행하는 역할
		boardDAO.deleteArticle(articleNo);
		return articleNoList;
	}
	
	//위의 addArticle과 완벽히 동일한 작업을 수행한다. 
	public int addReply(ArticleVO articleVO) {
		return boardDAO.insertNewArticle(articleVO);
	}
}
