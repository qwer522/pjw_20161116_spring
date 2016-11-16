package com.kgs7276.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kgs7276.spring.domain.Board;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	private static final String namespace="com.kgs7276.spring.mapper.BoardMapper";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void create(Board board) throws Exception {
		
		sqlSession.insert(namespace + ".create", board);
		
	}

	@Override
	public Board read(Integer bno) throws Exception {
		
		return sqlSession.selectOne(namespace + ".read", bno);
	}

	@Override
	public void update(Board board) throws Exception {
		
		sqlSession.update(namespace + ".update", board);
		
	}

	@Override
	public void delete(Integer bno) throws Exception {
		
		sqlSession.delete(namespace + ".delete", bno);
		
	}

	@Override
	public List<Board> listAll() throws Exception {
		
		return sqlSession.selectList(namespace + ".listAll");
		
	}

}
