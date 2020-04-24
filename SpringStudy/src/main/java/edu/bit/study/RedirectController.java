package edu.bit.study;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {

	private static final Logger logger = LoggerFactory.getLogger(RedirectController.class);

	@RequestMapping("/redirect/index")
	public String index() {
		logger.info("/redirect/index");		
		return "/redirect/index";
	}
	
	@RequestMapping("/redirect/confirm")
	public String confirm(HttpServletRequest request) {
		logger.info("/redirect/confirm");
		String id = request.getParameter("id");
		if(id.equals("test")) {
			return "redirect:/redirect/confirmOk";
		}
		
		return "redirect:/redirect/confirmNg";
	}
	
	@RequestMapping("/redirect/confirmOk")
	public String confirmOk() {
		logger.info("/redirect/confirmOk");		
		return "/redirect/confirmOk";
	}
	
	@RequestMapping("/redirect/confirmNg")
	public String confirmNg() {
		logger.info("/redirect/confirmNg");		
		return "/redirect/confirmNg";
	}
}
