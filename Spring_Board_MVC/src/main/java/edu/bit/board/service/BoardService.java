package edu.bit.board.service;

import java.util.List;
import edu.bit.board.vo.BoardVO;

public interface BoardService {
	public abstract List<BoardVO> getBoardList();
	public abstract int write(BoardVO board);
	public abstract BoardVO contentView(BoardVO boardVO);
	public abstract int delete(BoardVO boardVO);
	public abstract BoardVO modifyView(BoardVO boardVO);
	public abstract int modify(BoardVO boardVO);
	public abstract BoardVO replyView(BoardVO boardVO);
	public abstract int reply(BoardVO boardVO);
}
