package edu.bit.ex.board4;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service // new 객체생성
public class BService4 {
	@Inject  // 객체주입
	BoardMapper4 boardMapper4;
	
	public List<BoardVO> getBoardList() throws Exception{
		return boardMapper4.selectBoardList();
	}
}
