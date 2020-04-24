package edu.bit.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import edu.bit.board.page.Criteria;
import edu.bit.board.vo.BoardVO;

@Repository
public interface BoardMapper {
	@Select("SELECT COUNT(*) FROM BOARD")
	public abstract int selectCountBoard();
	
	public abstract List<BoardVO> selectBoardListPage(@Param("criteria") Criteria criteria);
	
	@Select("SELECT * FROM BOARD ORDER BY bGroup DESC, bStep ASC")
	public abstract List<BoardVO> selectBoardList();
	
	@Insert("INSERT INTO Board (bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent) VALUES (Board_seq.NEXTVAL, #{boardVO.bName}, #{boardVO.bTitle}, #{boardVO.bContent}, SYSDATE, 0, Board_seq.CURRVAL, 0, 0)")
	public abstract void insertBoard(@Param("boardVO") BoardVO boardVO);

	@Update("UPDATE BOARD SET bHit = bHit + 1 WHERE bId = #{bId}")
	public abstract void hitUp(@Param("bId") int bId);
	
	@Select("SELECT * FROM Board WHERE bId = #{bId}")
	public abstract BoardVO selectOne(@Param("bId") int bId);
		
	@Delete("DELETE FROM BOARD WHERE bId = #{bId}")
	public abstract void delete(@Param("bId") int bId);

	@Select("SELECT * FROM Board WHERE bId = #{bId}")
	public abstract BoardVO updateView(@Param("bId") int bId);

	@Update("UPDATE BOARD SET bTitle = #{boardVO.bTitle}, bContent = #{boardVO.bContent}, bDate = SYSDATE WHERE bId = #{boardVO.bId}")
	public abstract void update(@Param("boardVO") BoardVO boardVO);
	
	@Select("SELECT * FROM Board WHERE bId = #{bId}	")
	public abstract BoardVO replyView(@Param("bId") int bId);
		
	@Update("UPDATE BOARD SET bStep = bStep + 1 WHERE bGroup = #{bGroup} AND bStep > #{bStep}")
	public abstract void replyShape(@Param("bGroup") int bGroup, @Param("bStep") int bStep);
	
	@Insert("INSERT INTO Board (bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent) VALUES (Board_seq.NEXTVAL, #{boardVO.bName}, #{boardVO.bTitle}, #{boardVO.bContent}, SYSDATE, 0, #{boardVO.bGroup}, #{boardVO.bStep} + 1, #{boardVO.bIndent} + 1)")
	public abstract void replyWrite(@Param("boardVO") BoardVO boardVO);
}
