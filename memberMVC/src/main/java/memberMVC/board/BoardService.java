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
}
