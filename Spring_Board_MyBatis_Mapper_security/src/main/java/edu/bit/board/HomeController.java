package edu.bit.board;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/login/loginForm")
	public String loginForm(Model model) {
		logger.info("loginForm");
		return "login/loginForm2";
	}
	
	@RequestMapping("/user/userHome")
	public String userHome(Model model) {
		logger.info("userHome");
		return "user/user";
	}
	
	@RequestMapping("/admin/adminHome")
	public String adminHome(Model model) {
		logger.info("adminHome");
		return "admin/adminHome";
	}
	
	@RequestMapping("/login/accessDenied")
	public String accessDenied(Model model) {
		logger.info("accessDenied");
		return "login/accessDenied";
	}
	
	@RequestMapping("/loginInfo")
	public String loginInfo(Principal principal,Model model) {
		
		//1.Controller를 통하여 Principal객체로 가져오는 방법
		String user_id = principal.getName();
		System.out.println("user_id : " + user_id);
		
		//2.SpringContextHolder를 통하여 가져오는 방법
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        user_id = auth.getName();
        System.out.println("user_id : " + user_id);
        
    	//3.User 클래스로 변환 하여 가져오는 방법
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user_id = user.getUsername();
        System.out.println("user_id : " + user_id);
        
        return "home";
	}
	
}
