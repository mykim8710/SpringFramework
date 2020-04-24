package edu.bit.ex.board2;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service // new 객체생성
public class BService2 {
	@Inject  // 객체주입
	SqlSession sqlSession;
	
	public List<BoardVO> getBoardList() throws Exception{
		return sqlSession.selectList("board.getBoardList");
	}
}
