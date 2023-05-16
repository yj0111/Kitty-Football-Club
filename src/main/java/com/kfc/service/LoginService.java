package com.kfc.service;

import javax.servlet.http.HttpServletRequest;

import com.kfc.dto.User;

public interface LoginService {

	User login(User user, HttpServletRequest request);

	String getKakaoAccessToken (String code);

	String createKakaoUser(String token);

	User getUser(String id);
	
	String getUserInfo(String token);

	String getToken(String state, String code);

	User getUserNaver(String id);

	int signUp(User user);
}
