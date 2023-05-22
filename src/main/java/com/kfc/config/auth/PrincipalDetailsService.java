package com.kfc.config.auth;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kfc.dao.LoginDao;
import com.kfc.dto.User;


// 시큐리티 설정에서 .loginProcessingUrl("/kfc/login");
// 저 요청이 오면 자동으로 UserDetailsService 타입으로 Ioc  되어있는 PrincipalDetailsService함수가 실행 규칙임
@Service
public class PrincipalDetailsService implements UserDetailsService{
	@Autowired
	private HttpSession httpSession;
	@Autowired
	private LoginDao loginDao;
	//UserDetails 타입을 리턴하면 Authentication 내부에 쏙 들어감
	//이걸 세션에 들어감
	//시큐리티 session(내부Authentication(내부UserDetails)) 이런 식
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//username은 고정 이름이기 때문에 dto랑 맞춰주거나 config에서 바꿔 줘야 함
		User user = loginDao.findByUsername(username);
	//	User logined = (User) httpSession.getAttribute("loginUser");
		
		
		httpSession.setAttribute("loginUser", user);
		
		//이름만 확인하는 것 같지만 실제론 비밀번호를 알아서 검증해 준다.
		//디폴트가 bCryptPasswordEncoder.encode 되어서 검증 해줌.
		if(user == null) {
			  throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username);
		}

		return new PrincipalDetails(user); //user 검증하고 맞으면PrincipalDetails(user) 객체생성
	}

}