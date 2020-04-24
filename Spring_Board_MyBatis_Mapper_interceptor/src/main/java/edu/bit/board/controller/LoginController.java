package edu.bit.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.bit.board.service.LoginService;
import edu.bit.board.vo.UserVO;

@Controller
@RequestMapping("/member")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	//로그인처리
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, RedirectAttributes rttr) {
		System.out.println("로그인 호출");
		
		HttpSession session = request.getSession();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserVO login = loginService.loginUser(username, password);

		if (login == null) {
			// 새로고침하면 날라가는 데이터(일회성)
			rttr.addFlashAttribute("message", false);
		} else {
			session.setAttribute("member", login);
		}

		return "redirect:/";
	}
	
	@RequestMapping("/logout")
	public String logOut(HttpSession session) {
		System.out.println("로그아웃 호출");
		
		session.invalidate();	// session 해제

		return "redirect:/";
	}
	
	
}
