package edu.bit.study;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DataController {

	private static final Logger logger = LoggerFactory.getLogger(DataController.class);
	
	@RequestMapping("/dataSend/index")
	public String index(Model model) {
		logger.info("/dataSend/index");
	
		return "/dataSend/index";
	}
	
	@RequestMapping("/dataSend/httpServletRequest")
	public String httpServletRequest(HttpServletRequest request, Model model) {
		logger.info("/dataSend/httpServletRequest");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
			
		return "/dataSend/httpServletRequest";
	}
	
	@RequestMapping("/dataSend/requestParam")
	public String requestParam(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
		logger.info("/dataSend/requestParam");
				
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
			
		return "/dataSend/requestParam";
	}
}
