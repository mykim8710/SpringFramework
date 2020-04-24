package edu.bit.ex.board4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/* 1. 1번방식과 같은 방식, 대신 aqlSession.getMapper() 메서드를 사용하지않음
 * 2. 간단하고 심플
 * 3. root-context.xml에 아래의 한줄 추가
 * 	<!-- Mapper Interface -->
 * 	<mybatis-spring:scan base-package="edu.bit.ex.*" />
 */

@Controller
public class BController4 {
	@Autowired
	BService4 bService4;
	
	@RequestMapping("/list4")
	public String list4(Model model) throws Exception {
		System.out.println("/list4");
		
		model.addAttribute("list4", bService4.getBoardList());
		return "list4";
	}
}
