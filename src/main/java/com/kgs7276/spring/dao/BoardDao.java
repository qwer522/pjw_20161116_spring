package com.kgs7276.spring.dao;

import java.util.List;

import com.kgs7276.spring.domain.Board;

public interface BoardDao {

	public void create(Board board) throws Exception;
	
	public Board read(Integer bno) throws Exception;
	
	public void update(Board board) throws Exception;
	
	public void delete(Integer bno) throws Exception;
	
	public List<Board> listAll() throws Exception;
	
}