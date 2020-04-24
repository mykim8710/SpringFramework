package edu.bit.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.vo.BoardVO;

@Service
public class BoardService {
	@Autowired
	private BoardMapper boardMapper;

	public List<BoardVO> selectAll() {
		return boardMapper.selectAll();
	}

	public void insert(BoardVO boardVO) {
		boardMapper.insert(boardVO);
	}

	public BoardVO selectOne(int bId) {
		boardMapper.hitUp(bId);
		return boardMapper.selectOne(bId);
	}

	public void delete(int bId) {
		boardMapper.delete(bId);
	}

	public BoardVO modifyView(int bId) {
		return boardMapper.modifyView(bId);
	}

	public void modifyContent(BoardVO boardVO) {
		boardMapper.modifyContent(boardVO);
	}

	public BoardVO replyView(int bId) {
		return boardMapper.replyView(bId);
	}

	public void replyContent(BoardVO boardVO) {
		boardMapper.replyShape(boardVO.getbGroup(), boardVO.getbStep());
		boardMapper.replyContent(boardVO);
	}

}
