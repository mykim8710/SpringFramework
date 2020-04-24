package edu.bit.ex.board2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/* 1. 인터페이스가 필요없음
 * 2. sqlSession(MyBatis)에서 제공하는 함수 (selectList, selectOne)를 이용
 * 3. 쿼리구현을 위한 XML이 필요, 해당 XML의 namespace와 id는 개발자가 정의
 */

@Controller
public class BController2 {
	@Autowired
	BService2 bService2;
	
	@RequestMapping("/list2")
	public String list2(Model model) throws Exception {
		System.out.println("/list2");
		
		model.addAttribute("list2", bService2.getBoardList());
		return "list2";
	}
}
