package com.kfc.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		  
		HttpSession session = request.getSession();
		// 로그인 사용자 정보 가져오기
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        // JSESSIONID 설정
        String sessionId = session.getId();
        response.setHeader("JSESSIONID", sessionId);
    	Cookie cookie = new Cookie("JSESSIONID",sessionId); //어쩃든 포트 번호가 달라서 쿠키에 직접 넣어여해!!
		cookie.setPath("/");
		response.addCookie(cookie);
        // loginUser 정보를 JSON 형태로 생성
        String username = userDetails.getUsername();
        String jsonResponse = "{ \"message\": \"success\", \"username\": \"" + username + "\" }";
        
        response.setContentType("application/json");
        response.getWriter().write(jsonResponse);

	}

}
