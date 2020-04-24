package edu.bit.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.board.page.Criteria;
import edu.bit.board.page.PageMaker;
import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/boardList2")
	public String boardList2(Criteria criteria, Model model) {
		System.out.println("/boardList2() method");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(criteria);
		
		System.out.println("criteria : " +criteria);
		System.out.println("criteria.getPerPageNum() : " +criteria.getPerPageNum());
		System.out.println("criteria.getPage() : " +criteria.getPage());
		
		int totalCount = boardService.selectCountBoard();
		System.out.println("전체 게시물의 수 : " +totalCount);
		
		// 전체값 세팅
		pageMaker.setTotalCount(totalCount);
		List<BoardVO> boardList = boardService.selectBoardListPage(criteria);
				
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageMaker", pageMaker);
		return "boardList2";
	}

	@RequestMapping("/boardList")
	public String boardList(Model model) {
		System.out.println("/boardList() method");
		model.addAttribute("boardList", boardService.selectBoardList());
		return "boardList";
	}

	@RequestMapping("/writeView")
	public String writeView() {
		System.out.println("/writeView() method");
		return "writeView";
	}

	@RequestMapping("/writeContent")
	public String writeContent(BoardVO boardVO) {
		System.out.println("/writeContent() method");
		boardService.insertBoard(boardVO);
		return "redirect:/boardList2";
	}

	@RequestMapping("/contentView")
	public String contentView(BoardVO boardVO, Model model) {
		System.out.println("/contentView() method");
		model.addAttribute("content", boardService.selectOne(boardVO));
		return "contentView";
	}
	
	@RequestMapping("/deleteContent")
	public String deleteContent(BoardVO boardVO) {
		System.out.println("/deleteContent() method");
		boardService.delete(boardVO);
		return "redirect:/boardList2";
	}
	
	@RequestMapping("/modifyView")
	public String modifyView(BoardVO boardVO, Model model) {
		System.out.println("/modifyView() method");
		model.addAttribute("modify", boardService.updateView(boardVO));
		return "modifyView";
	}
	
	@RequestMapping("/modifyContent")
	public String modifyContent(BoardVO boardVO) {
		System.out.println("/modifyContent() method");
		boardService.update(boardVO);
		return "redirect:/boardList2";
	}
	
	@RequestMapping("/replyView")
	public String replyView(BoardVO boardVO, Model model) {
		System.out.println("/replyView() method");
		model.addAttribute("reply", boardService.replyView(boardVO));
		return "replyView";
	}
	
	@RequestMapping("/replyContent")
	public String replyContent(BoardVO boardVO) {
		System.out.println("/replyContent() method");
		boardService.insertReply(boardVO);
		return "redirect:/boardList2";
	}

}
