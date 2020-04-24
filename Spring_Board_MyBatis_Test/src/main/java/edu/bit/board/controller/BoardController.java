package edu.bit.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;

	@RequestMapping("/boardList")
	public String boardList(Model model) {
		System.out.println("boardList() method");
		List<BoardVO> boardList = boardService.selectAll();
		model.addAttribute("boardList", boardList);
		return "boardList";
	}

	@RequestMapping("/writeView")
	public String writeView() {
		System.out.println("writeView()");
		return "writeView";
	}

	@RequestMapping("/writeContent")
	public String writeContent(BoardVO boardVO) {
		System.out.println("writeContent() method");
		boardService.insert(boardVO);
		return "redirect:boardList";
	}

	@RequestMapping("/contentView")
	public String contentView(BoardVO boardVO, Model model) {
		System.out.println("contentView() method");
		BoardVO vo = boardService.selectOne(boardVO.getbId());
		model.addAttribute("content", vo);
		return "contentView";
	}

	@RequestMapping("/deleteContent")
	public String deleteContent(BoardVO boardVO) {
		System.out.println("deleteContent()");
		boardService.delete(boardVO.getbId());
		return "redirect:boardList";
	}

	@RequestMapping("/modifyView")
	public String modifyView(BoardVO boardVO, Model model) {
		System.out.println("modifyView() method");
		BoardVO vo = boardService.modifyView(boardVO.getbId());
		model.addAttribute("modify", vo);
		return "modifyView";
	}

	@RequestMapping("/modifyContent")
	public String modifyContent(BoardVO boardVO) {
		System.out.println("modifyContent() method");
		boardService.modifyContent(boardVO);
		return "redirect:boardList";
	}

	@RequestMapping("/replyView")
	public String replyView(BoardVO boardVO, Model model) {
		System.out.println("replyView() method");
		BoardVO vo = boardService.replyView(boardVO.getbId());
		model.addAttribute("reply", vo);
		return "replyView";
	}

	@RequestMapping("/replyContent")
	public String replyContent(BoardVO boardVO) {
		System.out.println("replyContent() method");
		boardService.replyContent(boardVO);
		return "redirect:boardList";
	}

}
