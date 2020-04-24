package edu.bit.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.board.page.Criteria;
import edu.bit.board.page.PageMaker;
import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;

@Controller
@RequestMapping("/notice")
public class BoardController {
	@Autowired
	private BoardService boardService;

	@RequestMapping("/list")
	public String list(Criteria criteria, Model model, HttpSession session) {
		System.out.println("/list() method");

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(criteria);

		System.out.println("criteria : " + criteria);
		System.out.println("criteria.getPerPageNum() : " + criteria.getPerPageNum());
		System.out.println("criteria.getPage() : " + criteria.getPage());

		int totalCount = boardService.selectCountBoard();
		System.out.println("전체 게시물의 수 : " + totalCount);

//		방법1 : 로그인이 되지않으면 게시판으로 못들어가게하기 위한 코드 UserVO member = (UserVO)
//		UserVO member = (UserVO) session.getAttribute("member");
//		if (member == null) {
//			System.out.println("멤버 세션값 없음");
//			return "redirect:/";
//		}
		
		// 전체값 세팅
		pageMaker.setTotalCount(totalCount);
		List<BoardVO> boardList = boardService.selectBoardListPage(criteria);

		model.addAttribute("boardList", boardList);
		model.addAttribute("pageMaker", pageMaker);
		return "list";
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
		return "redirect:/notice/list";
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
		return "redirect:/notice/list";
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
		return "redirect:/notice/list";
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
		return "redirect:/notice/list";
	}
}
