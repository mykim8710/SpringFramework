package edu.bit.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CmdObjController {

	private static final Logger logger = LoggerFactory.getLogger(CmdObjController.class);
	
	@RequestMapping("/commandObj/input")
	public String input(Model model) {
		logger.info("/commandObj/input");
	
		return "/commandObj/input";
	}
	
	@RequestMapping("/commandObj/getArea")
	public String httpServletRequest(CalcArea calcArea) {
		logger.info("/commandObj/getArea");
			
		return "/commandObj/getArea";
	}
}
