package edu.bit.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;

@RestController
@RequestMapping("/rest/*")
public class BoardRestController {
	@Autowired
	private BoardService boardService;

	@RequestMapping("/boardList")
	public List<BoardVO> boardList() {
		System.out.println("boardList() method");
		return boardService.selectAll();
	}

}
