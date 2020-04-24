package edu.bit.board.controller;

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

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("/list");
		model.addAttribute("boardList", boardService.getBoardList());
		return "/list";
	}

	@RequestMapping("/write_view")
	public String writeView() {
		System.out.println("/write_view");
		return "/write_view";
	}

	@RequestMapping("/write")
	public String write(BoardVO boardVO) {
		System.out.println("/write");
		int rn = boardService.write(boardVO);
		System.out.println("결과값 : " + rn);
		return "redirect:/list";
	}

	@RequestMapping("/content_view")
	public String contentView(BoardVO boardVO, Model model) {
		System.out.println("/content_view");
		model.addAttribute("vo", boardService.contentView(boardVO));
		return "/content_view";
	}
	
	@RequestMapping("/delete")
	public String delete(BoardVO boardVO) {
		System.out.println("/delete");
		int rn = boardService.delete(boardVO);
		System.out.println("결과값 : " + rn);
		return "redirect:/list";
	}
	
	@RequestMapping("/modify_view")
	public String modifyView(BoardVO boardVO, Model model) {
		System.out.println("/modify_view");
		model.addAttribute("vo", boardService.modifyView(boardVO));
		return "modify_view";
	}
	
	@RequestMapping("/modify")
	public String modify(BoardVO boardVO) {
		System.out.println("/modify");
		int rn = boardService.modify(boardVO);
		System.out.println("결과값 : " + rn);
		return "redirect:/list";
	}

	@RequestMapping("/reply_view")
	public String replyView(BoardVO boardVO, Model model) {
		System.out.println("/reply_view");
		model.addAttribute("vo", boardService.replyView(boardVO));
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(BoardVO boardVO) {
		System.out.println("/reply");
		int rn = boardService.reply(boardVO);
		System.out.println("결과값 : " + rn);
		return "redirect:/list";
	}
	
}
