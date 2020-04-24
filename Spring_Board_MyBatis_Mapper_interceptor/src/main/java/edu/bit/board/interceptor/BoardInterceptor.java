package edu.bit.board.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import edu.bit.board.vo.UserVO;

public class BoardInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("preHandle() 실행");

		HttpSession session = request.getSession();
		UserVO member = (UserVO) session.getAttribute("member");
		
		// 로그인이 안되어있는 상태임으로 로그인폼으로 다시 돌려보냄(sendRediect)
		if (member == null) {
			response.sendRedirect(request.getContextPath());
			return false;
		}
		// preHandle() 메서드의 return은 컨트롤러 요청 URI로 가도되는지 안되는지를 허가하는 의미
		// 따라서 true로 하면 컨트롤러만 URI로 가게됨
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
		System.out.println("postHandle() 실행");
	}

}
