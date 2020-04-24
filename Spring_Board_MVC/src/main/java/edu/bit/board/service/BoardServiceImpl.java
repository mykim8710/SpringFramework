package edu.bit.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.board.dao.BoardDAO;
import edu.bit.board.vo.BoardVO;


@Service("boardService")
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> getBoardList() {
		return boardDAO.getBoardList();
	}

	@Override
	public int write(BoardVO boardVO) {
		return boardDAO.write(boardVO);
	}

	@Override
	public BoardVO contentView(BoardVO boardVO) {
		return boardDAO.contentView(boardVO);
	}

	@Override
	public int delete(BoardVO boardVO) {
		return boardDAO.delete(boardVO);
	}

	@Override
	public BoardVO modifyView(BoardVO boardVO) {
		return boardDAO.modifyView(boardVO);
	}

	@Override
	public int modify(BoardVO boardVO) {
		return boardDAO.modify(boardVO);
	}

	@Override
	public BoardVO replyView(BoardVO boardVO) {
		return boardDAO.replyView(boardVO);
	}

	@Override
	public int reply(BoardVO boardVO) {
		return boardDAO.reply(boardVO);
	}
	
}
