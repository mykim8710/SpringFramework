package edu.bit.member;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@RequestMapping("/login")
	public String login() {
		logger.info("login.jsp");
		return "/login";
	}

	@RequestMapping("/loginOk")
	public String loginOk(@Valid Member member, BindingResult bindingResult) {
		String viewPage = "/loginOk";
		logger.info("loginOk.jsp");

		MemberValidator validator = new MemberValidator();
		validator.validate(member, bindingResult);

		if (bindingResult.hasErrors()) {
			viewPage = "/login";
		}

		return viewPage;
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new MemberValidator());
	}
}
