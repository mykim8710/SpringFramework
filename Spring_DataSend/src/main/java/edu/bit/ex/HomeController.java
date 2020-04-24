package edu.bit.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.bit.ex.member.Member;
import edu.bit.ex.student.StudentInformation;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping("/board/confirm")
	public String confirm(HttpServletRequest request, Model model) {
		logger.info("confirm");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		model.addAttribute("id", id);
		model.addAttribute("pw", pw);

		return "board/confirm";
	}

	@RequestMapping("/board/confirm2")
	public String confirm2(@RequestParam("id") String id, @RequestParam("pw") int pw, Model model) {
		logger.info("confirm2");

		model.addAttribute("id", id);
		model.addAttribute("pw", pw);

		return "board/confirm2";
	}

	@RequestMapping("/board/confirm3")
	public String confirm3(Member member) {
		logger.info("confirm3");

		return "board/confirm3";
	}

	@RequestMapping("/index")
	public String index() {
		logger.info("index");
		return "index";
	}

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public String student(HttpServletRequest request, Model model) {
		logger.info("student");
		logger.info("RequestMethod.POST");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		logger.info("id : " + id);
		logger.info("pw : " + pw);

		model.addAttribute("id", id);
		model.addAttribute("pw", pw);

		return "student";
	}
	
	// 메서드 오버로딩
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public ModelAndView student(HttpServletRequest request) {
		logger.info("student");
		logger.info("RequestMethod.GET");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		logger.info("id : " + id);
		logger.info("pw : " + pw);

		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);
		mv.addObject("pw", pw);
		mv.setViewName("student");
		
		return mv;
	}
	
	@RequestMapping("/index2")
	public String index2() {
		logger.info("index2");
		return "index2";
	}
	
	@RequestMapping(value = "/studentView", method = RequestMethod.POST)
	public String studentView(@ModelAttribute("studentInfo") StudentInformation studentInformation) {
		return "studentView";
	}
	
}
