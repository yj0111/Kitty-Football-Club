package com.kfc.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kfc.dto.User;
import com.kfc.service.LoginService;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/kfc")
@Api(tags = "로그인 컨트롤러")
public class LoginController {
	@Autowired
	LoginService loginService; 
	
	//일반 로그인
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user, HttpServletRequest request){
		User isSuccess = loginService.login(user, request);

		return new ResponseEntity<>(isSuccess, HttpStatus.ACCEPTED);
	}
	//카카오 로그인
	@GetMapping(value = "/oauth")
	public void kakaoConnect(HttpServletResponse response) throws IOException {
	
		StringBuffer url = new StringBuffer();
		url.append("https://kauth.kakao.com/oauth/authorize?");
		url.append("client_id=" + "0d71d6cba5e7587e9e8f923fe4fa9212");
		url.append("&redirect_uri=http://localhost:8080/kfc/kakaoCallback");
		url.append("&response_type=code");
		response.sendRedirect(String.valueOf(url));
	}

	@GetMapping(path = "/kakaoCallback")
	public ResponseEntity<String> kakaoCallback(@RequestParam String code, HttpSession session) {
		System.out.println("cod" + code);
		String response = "";
		String token = loginService.getKakaoAccessToken(code);
		String id = loginService.createKakaoUser(token);
		response = id;
		System.out.println(id);
		User user = loginService.getUser(id);
		if(user == null){
			//회원가입 페이지로 보내!!
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}else{
			session.setAttribute("loginUser" , user);
			//메인으로 보내!!
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
	
	//네이버 로그인
	@GetMapping("/naverLogin")
	public  void naverConnect(HttpServletResponse response) throws IOException {
		//state 용 난수 생성
		SecureRandom random = new SecureRandom();
		String state = new BigInteger(130, random).toString(32);

		//redirect
		StringBuffer url = new StringBuffer();
		url.append("https://nid.naver.com/oauth2.0/authorize?");
		url.append("client_id=gaTGmrrb4UV7xeZFXhjb");
		url.append("&response_type=code");
		url.append("&redirect_uri=http://localhost:8080/kfc/naverCallback");
		url.append("&state=" + state);

		response.sendRedirect(String.valueOf(url));
	}

	@GetMapping(path = "/naverCallback")
	public ResponseEntity<String> naverCallback(@RequestParam String state, @RequestParam String code, HttpSession session) {
		String token = loginService.getToken(state, code);
		String id = loginService.getUserInfo(token);
		System.out.println(id);
		User user = loginService.getUserNaver(id);
		if(user == null){
			//회원가입 페이지로 보내!!
			return new ResponseEntity<>(id, HttpStatus.BAD_REQUEST);
		}else{
			//메인으로 보내!!
			session.setAttribute("loginUser" , user);
			return new ResponseEntity<>(id, HttpStatus.OK);
		}
	}
	//회원 가입
	@PostMapping("/signup")
	public ResponseEntity<Integer> signup(User user) {
		int result = loginService.signUp(user);
		
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}
	//로그아웃
	@GetMapping("logout")
	public ResponseEntity<Void> logout(HttpSession session) {
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
