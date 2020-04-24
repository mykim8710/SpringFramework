package edu.bit.ex.board1;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service // new 객체생성
public class BService1 {
	@Inject  // 객체주입 = @Autowired
	SqlSession sqlSession;
	
	public List<BoardVO> getBoardList() throws Exception{
		IBDao dao = sqlSession.getMapper(IBDao.class);
		return dao.listDao();
	}
}
