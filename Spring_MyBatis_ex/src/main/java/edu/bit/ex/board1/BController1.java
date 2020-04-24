package edu.bit.ex.board1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/* 1. interface IBDao를 board1.XML namespace에 맵핑 <mapper namespace="edu.bit.ex.board1.IBDao">
 * 2. sqlSession.getMapper(IBDao.class)를 이용
 */

@Controller
public class BController1 {
	@Autowired
	BService1 bService1;
	
	@RequestMapping("/list1")
	public String list1(Model model) throws Exception {
		System.out.println("/list1");
		
		model.addAttribute("list1", bService1.getBoardList());
		return "list1";
	}
}
