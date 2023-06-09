package com.myspring.stsproject.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.stsproject.board.service.BoardService;
import com.myspring.stsproject.board.vo.ArticleVO;

@Controller("boardController")
public class BoardControllerImpl implements BoardController {
	private static String ART_IMAGE_REPO = "D:\\HIH\\backend\\stsproject\\image_repo";
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private ArticleVO articleVO;
	
	@Override
	@RequestMapping(value="/board/listArticles.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//interceptor
		String viewName = (String)request.getAttribute("viewName");
		
		List articleList = boardService.listArticles();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("aList", articleList);
		return mav;
	}
}