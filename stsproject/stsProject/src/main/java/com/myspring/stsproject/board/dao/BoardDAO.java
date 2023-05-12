package com.myspring.stsproject.board.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface BoardDAO {
	
	public List selectAllArticles() throws DataAccessException;
}
