package com.kfc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//요기서 한번 검사를 해야겠다.
		HttpSession session = request.getSession();
		//로그인할때 이렇게 id를 직접 세션에 담아 두었다라고 가정
		if(session.getAttribute("loginUser") == null) {
			//redirect를 로그인 페이지로 가야해!
			//response.sendRedirect("login");
			return false;
		}
		return true; 
		
		
	}
}
