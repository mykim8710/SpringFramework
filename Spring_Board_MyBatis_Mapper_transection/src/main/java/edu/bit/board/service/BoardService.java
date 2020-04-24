package edu.bit.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.page.Criteria;
import edu.bit.board.vo.BoardVO;

@Service
public class BoardService {
	@Autowired
	private BoardMapper boardMapper;
	
	// 게시판 list 출력을 위한 로직
	public List<BoardVO> selectBoardList() {
		return boardMapper.selectBoardList();
	}
	
	// 게시판 글작성을 위한 로직
	public void insertBoard(BoardVO boardVO) {
		boardMapper.insertBoard(boardVO);
	}
	
	// 선택한 게시물을 보여주는 로직
	public BoardVO selectOne(BoardVO boardVO) {
		boardMapper.hitUp(boardVO.getbId());
		return boardMapper.selectOne(boardVO.getbId());
	}
	
	// 선택한 게시물 삭제하는 로직
	public void delete(BoardVO boardVO) {
		boardMapper.delete(boardVO.getbId());
	}
	
	// 선택한 게시물을 수정하기위한 페이지로 이동하는 로직
	public BoardVO updateView(BoardVO boardVO) {
		return boardMapper.updateView(boardVO.getbId());
	}
	
	// 선택한 게시물을 수정(수정한 내용)하는 로직
	public void update(BoardVO boardVO) {
		boardMapper.update(boardVO);
	}

	// 선택한 게시물에 댓글을 달기 위한 페이지로 이동하는 로직
	public BoardVO replyView(BoardVO boardVO) {
		return boardMapper.replyView(boardVO.getbId());
	}
	
	// 선택한 게시물에 작성한 댓글이 등록되는 로직
	public void insertReply(BoardVO boardVO) {
		boardMapper.replyShape(boardVO.getbGroup(), boardVO.getbStep());
		boardMapper.replyWrite(boardVO);
	}
	
	// DB에 있는 총 게시물의 개수를 도출하는 로직
	public int selectCountBoard() {
		return boardMapper.selectCountBoard();
	}

	public List<BoardVO> selectBoardListPage(Criteria criteria) {
		return boardMapper.selectBoardListPage(criteria);
	}	
}
