package com.kgs7276.spring;

import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kgs7276.spring.domain.Board;
import com.kgs7276.spring.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class BoardServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceTest.class);
	
	@Inject
	BoardService service;
		
	@Test
	public void testCreate() throws Exception {
		
		logger.info("testCreate() 호출됨.");		
		Board board = new Board("AAA", "AAA", "AAA");		
		service.regist(board);	
		
	}
	
	@Ignore ("테스트 수행하지 않도록 설정 함 (실제론 상세 원인을 표시)")
	@Test
	public void testRead() throws Exception {
		
		logger.info("testRead() 호출됨.");
		int bno = 1;
		Board board = service.read(bno);
		logger.info(board.toString());
		
	}
	
	@Ignore ("테스트 수행하지 않도록 설정 함 (실제론 상세 원인을 표시)")
	@Test
	public void testUpdate() throws Exception {
		
		logger.info("testUpdate() 호출됨.");		
		Board board = new Board(1, "JSP란", "지금 보니 날 코딩이다.");		
		service.modify(board);
		
	}
	
	@Ignore ("테스트 수행하지 않도록 설정 함 (실제론 상세 원인을 표시)")
	@Test
	public void testDelete() throws Exception {
		
		logger.info("testDelete() 호출됨.");
		int bno = 1;
		service.remove(bno);
		
	}
	
	@Ignore ("테스트 수행하지 않도록 설정 함 (실제론 상세 원인을 표시)")	
	@Test
	public void testListAll() throws Exception {
		
		logger.info("testListAll() 호출됨.");
		List<Board> list = service.listAll();
		
		for(int i = 0 ; i < list.size() ; i++) {
			logger.info(list.get(i).toString());
		}
		
	}
	
}





