package edu.bit.ex.board3;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service // new 객체생성
public class BService3 {
	@Inject  // 객체주입
	BoardMapper3 boardMapper;
	
	public List<BoardVO> getBoardList() throws Exception{
		return boardMapper.selectBoardList();
	}
}
