package edu.bit.ex.board3;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface BoardMapper3 {
	@Select("SELECT bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent FROM BOARD ORDER BY bGroup DESC, bStep ASC")	
	public abstract List<BoardVO> selectBoardList();
}
