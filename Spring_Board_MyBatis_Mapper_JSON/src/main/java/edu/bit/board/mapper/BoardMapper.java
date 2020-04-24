package edu.bit.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import edu.bit.board.vo.BoardVO;

@Repository
public interface BoardMapper {
	public abstract List<BoardVO> selectAll();

	public abstract void insert(@Param("boardVO") BoardVO boardVO);
	
	@Update("UPDATE BOARD SET bHit = bHit + 1 WHERE bId = #{bId}")
	public abstract void hitUp(@Param("bId") int getbId);
	
	public abstract BoardVO selectOne(@Param("bId") int getbId);
		
	@Delete("DELETE FROM BOARD WHERE bId = #{bId}")
	public abstract void delete(@Param("bId") int getbId);

	public abstract BoardVO modifyView(@Param("bId") int getbId);

	public abstract void modifyContent(@Param("boardVO") BoardVO boardVO);

	public abstract BoardVO replyView(@Param("bId") int getbId);
	
	public abstract void replyContent(@Param("boardVO") BoardVO boardVO);
	
	@Update("UPDATE BOARD SET bStep = bStep + 1 WHERE bGroup = #{bGroup} AND bStep > #{bStep}")
	public abstract void replyShape(@Param("bGroup") int bGroup, @Param("bStep") int bStep);
}
