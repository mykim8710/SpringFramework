package edu.bit.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelController {

	private static final Logger logger = LoggerFactory.getLogger(ModelController.class);

	@RequestMapping("/model/modelTest")
	public String modelTest(Model model) {
		logger.info("modelTest");
		model.addAttribute("name", "홍길동");
		model.addAttribute("age", 20);
		model.addAttribute("hobby", "운동");
				
		return "model/modelTest";
	}
	
	@RequestMapping("/model/modelAndView")
	public ModelAndView modelTest() {
		logger.info("modelTest");
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", "안철수");
		mv.addObject("age", 55);
		mv.setViewName("model/modelAndView");
		
		return mv;
	}
}
