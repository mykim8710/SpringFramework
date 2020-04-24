package edu.bit.ex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContentController {
	private static final Logger logger = LoggerFactory.getLogger(ContentController.class);
	
	@RequestMapping(value = "/Board/content", method = RequestMethod.GET)
	public String content(Model model) {
		logger.info("/Board/content 실행");
		model.addAttribute("id", "asdasdasd");
		model.addAttribute("pw", 1023465);
		return "Board/content";
	}
}
