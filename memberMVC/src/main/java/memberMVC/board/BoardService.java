package memberMVC.board;

import java.util.List;

public class BoardService {
	BoardDAO boardDAO;
	
	public BoardService() {
		//생성자에서 BoardDAO객체를 생성
		boardDAO = new BoardDAO();
	}
	
	public List<ArticleVO> listArticles(){
		List<ArticleVO> articleList = boardDAO.selectAllArticles();
		return articleList;
	}
	//      ↓여기변경 BoardDAO > insertNewArticle()
	public int addArticle(ArticleVO articleVO) {
		return boardDAO.insertNewArticle(articleVO);
	}
	
	public ArticleVO viewArticle(int articleNo) {
		ArticleVO articleVO = null;
		articleVO = boardDAO.selectArticle(articleNo);
		return articleVO;
	}
	
	public void modArticle(ArticleVO articleVO) {
		boardDAO.updateArticle(articleVO);
	}
}
