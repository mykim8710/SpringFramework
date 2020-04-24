package edu.bit.ex.board4;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface BoardMapper4 {
		
	public abstract List<BoardVO> selectBoardList();
	
}
