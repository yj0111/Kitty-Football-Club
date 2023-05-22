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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.kfc.config.auth.PrincipalDetails;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();

		HttpSession session = request.getSession();
		// 로그인 사용자 정보 가져오기
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        //중복 로그인 방지 위해 true로 변경
      
        // JSESSIONID 설정
        String sessionId = session.getId();
        response.setHeader("JSESSIONID", sessionId);
    	Cookie cookie = new Cookie("JSESSIONID",sessionId); //어쩃든 포트 번호가 달라서 쿠키에 직접 넣어여해!!
		cookie.setPath("/");
		response.addCookie(cookie);
        // loginUser 정보를 JSON 형태로 생성 여기서 넣어 줘야 사용 가능
        String user_id = userDetails.getUsername();
        String user_pic = principal.getUserpic();
        String user_name = principal.getUser_name();
        String jsonResponse = "{ \"message\": \"success\", \"username\": \"" + user_id + "\", \"user_pic\": \"" + user_pic + "\", \"user_name\": \"" + user_name + "\" }";
        
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);
      
	}

}
