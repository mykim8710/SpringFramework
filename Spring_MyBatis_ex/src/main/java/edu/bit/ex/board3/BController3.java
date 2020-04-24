package edu.bit.ex.board3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/* 1. 인터페이스 위에 @Select("쿼리문") 붙이는 형식
 * 2. XML이 필요없음, sqlSession 객체가 필요없음
 * 3. root-context.xml에 아래의 한줄 추가
 * 	<!-- Mapper Interface -->
 * 	<mybatis-spring:scan base-package="edu.bit.ex.*" />
 * 4. 쿼리문이 길어지면 사용하기 힘듬
 */

@Controller
public class BController3 {
	@Autowired
	BService3 bService3;
	
	@RequestMapping("/list3")
	public String list3(Model model) throws Exception {
		System.out.println("/list3");
		
		model.addAttribute("list3", bService3.getBoardList());
		return "list3";
	}
}
