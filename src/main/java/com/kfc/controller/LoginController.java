package com.kfc.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	@Autowired
	ResourceLoader resLoader;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	//일반 로그인 하하
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user, HttpServletRequest request,HttpServletResponse response){
		User isSuccess = loginService.login(user, request);
		
		HttpSession session = request.getSession();
		System.out.println("ewe"+ session.getAttribute("loginUser"));
		String sessionId = session.getId();
		Cookie cookie = new Cookie("JSESSIONID",sessionId);
		cookie.setPath("/");
		response.addCookie(cookie);
		return new ResponseEntity<>(isSuccess, HttpStatus.ACCEPTED);
	}
	//카카오 로그인
	@GetMapping(value = "/oauth")
	public void kakaoConnect(HttpServletResponse response) throws IOException {
	
		StringBuffer url = new StringBuffer();
		url.append("https://kauth.kakao.com/oauth/authorize?");
		url.append("client_id=" + "0d71d6cba5e7587e9e8f923fe4fa9212");
		url.append("&redirect_uri=http://localhost:8080/login");
		url.append("&response_type=code");
		response.sendRedirect(String.valueOf(url));
	}

	@GetMapping(path = "/kakaoCallback")
	public ResponseEntity<?> kakaoCallback(@RequestParam String code, HttpSession session ,HttpServletResponse response) {
		System.out.println("cod" + code);
		String responses = "";
		String token = loginService.getKakaoAccessToken(code);
		
		String id = loginService.createKakaoUser(token);
		responses = id;
		System.out.println(id);
		User user = loginService.getUser(id);
		
		if(user == null){
			//회원가입 페이지로 보내!!
			HashMap<String, String> map = new HashMap<String, String>();
			responses = "signUp";
			map.put("key", "signUp");
			map.put("id", id);
			return new ResponseEntity<>(map,  HttpStatus.OK);
		}else{
			session.setAttribute("loginUser" , user);
			String sessionId = session.getId();
			Cookie cookie = new Cookie("JSESSIONID",sessionId);
			cookie.setPath("/");
			response.addCookie(cookie);
			//메인으로 보내!!
			return new ResponseEntity<>(user, HttpStatus.OK);
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
		url.append("&redirect_uri=http://localhost:8080/login");
		url.append("&state=" + state);

		response.sendRedirect(String.valueOf(url));
	}

	@GetMapping(path = "/naverCallback")
	public ResponseEntity<?> naverCallback(@RequestParam String state, @RequestParam String Navercode, HttpSession session,HttpServletResponse response) {
		String token = loginService.getToken(state, Navercode);
		String id = loginService.getUserInfo(token);
		System.out.println("naverid : " + id);
		User user = loginService.getUserNaver(id);
		if(user == null){
			//회원가입 페이지로 보내!!
			String responses = "signUp";
			return new ResponseEntity<>(responses, HttpStatus.BAD_REQUEST);
		}else{
			//메인으로 보내!!
			session.setAttribute("loginUser" , user);
			String sessionId = session.getId();
			Cookie cookie = new Cookie("JSESSIONID",sessionId);
			cookie.setPath("/");
			response.addCookie(cookie);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
	}
	
	//회원 가입
	
	@Value("${upload.path}")
	private String uploadPath;
	@PostMapping("/signup")
	 public ResponseEntity<Integer> signup(User user ,@RequestPart(required = false) MultipartFile file) throws IllegalStateException, IOException {
		
		
		// 만약에 등록하려고 하는 upload 폴더가 없을 수도 있다.
		File folder = new File(uploadPath);
		if (!folder.exists())
			folder.mkdir(); // 폴더 없으면 만들어
		
        if (file != null && file.getSize() > 0) {
            // 파일을 저장할 위치 지정
      //      Resource res = resLoader.getResource("classpath:/static/upload");
 
         
         
            // 중복방지를 위해 파일 이름앞에 현재 시간 추가
            String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            String filePath = uploadPath + File.separator + filename; // 파일 경로

            // 파일 저장
            file.transferTo(new File(filePath));
            user.setUser_pic(filename);

        }
        
        //암호화 하기
        String encpassword = bCryptPasswordEncoder.encode(user.getUser_password()) ;
        user.setUser_password(encpassword);
        // DB에 user 정보 등록
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
