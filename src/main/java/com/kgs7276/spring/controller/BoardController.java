package com.kgs7276.spring.controller;


import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kgs7276.spring.domain.Board;
import com.kgs7276.spring.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	//void는 리턴없음
	//String 은 리턴있음
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public void requestRegisterForm() throws Exception {
		
		logger.info("글쓰기 화면을 요청함.");
		
	}
	
//	@RequestMapping(value="/register", method = RequestMethod.POST)
//	public String requestRegisterPro(Board board, Model model) throws Exception {
//		
//		logger.info("글쓰기를 요청함.");
//		
//		service.regist(board);
//		
//		model.addAttribute("result", "success");
//		
////		return "/board/success";
//		return "redirect:/board/listAll";
//		
//	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String requestRegisterPro(Board board, RedirectAttributes rttr) throws Exception {//Exception나면 톰켓에 던진다. 톰켓이 호출지점이여서
		
		logger.info("글쓰기를 요청함.");
		
		service.regist(board);
		
		rttr.addFlashAttribute("result", "success");
		
//		return "/board/success";
		return "redirect:/board/listAll";
		
	}
	
	@RequestMapping(value="/listAll", method = RequestMethod.GET)
	public void requestListAll(Model model) throws Exception {
		
		logger.info("글목록을 요청함.");		
	
		List<Board> list = service.listAll();
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value="/read", method = RequestMethod.GET)
	public void requestRead(@RequestParam("bno") int bno, Model model) throws Exception {//리퀘 파라미터하면 알아서 캐스팅함
		
		logger.info("글조회를 요청함.");
		Board board = service.read(bno);
		model.addAttribute("board", board);
	
	}
	
	@RequestMapping(value="/remove", method = RequestMethod.POST)
	public String requestRemove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {//리퀘 파라미터하면 알아서 캐스팅함
		
		logger.info("글삭제를 요청함.");
		
		service.remove(bno);
		rttr.addAttribute("result", "success");
		
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.GET)
	public void requestModifyForm(@RequestParam("bno") int bno, Model model) throws Exception {//Board넘어오는 값들을 알아서 만든다
		
		logger.info("글수정를 화면을 요청함.");
		
		Board board = service.read(bno);
		model.addAttribute("board", board);
		
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String requestModifyPro(Board board, RedirectAttributes rttr) throws Exception {//Board넘어오는 값들을 알아서 만든다
		
		logger.info("글삭제를 요청함.");
		
		service.modify(board);
		rttr.addAttribute("result", "success");
		
		return "redirect:/board/listAll";
		//return "redirect:/board/read?bno="+board.getBno();
	}
}







