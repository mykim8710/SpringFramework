package edu.bit.ex;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@RequestMapping("/createPage")
	public String createPage() {
		logger.info("/studentForm");
		return "/createPage";
	}

//	@RequestMapping("/student/create")
//	public String studentCreate(Student student, BindingResult bindingResult) {
//		logger.info("/student/create");
//		String page = "/createPageDone";
//
//		StudentValidator validator = new StudentValidator();
//		validator.validate(student, bindingResult);
//
//		if (bindingResult.hasErrors()) {
//			page = "/createPage";
//		}
//
//		return page;
//	}
	
	@RequestMapping("/createPageDone")
	public String studentCreate(@Valid Student student, BindingResult bindingResult) {
		logger.info("/student/create");
		String page = "/createPageDone";

		StudentValidator validator = new StudentValidator();
		validator.validate(student, bindingResult);

		if (bindingResult.hasErrors()) {
			page = "/createPage";
		}

		return page;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}
}
