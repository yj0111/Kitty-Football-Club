package com.kfc.config;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlAuthenticationStrategy;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.RequestContextFilter;

@Configuration // IoC 빈(bean)을 등록
@EnableWebSecurity // 필터 체인 관리 시작 어노테이션 활성화 하기!스프링 시큐리티 필터가 스프링 필터체인에 등록 됨
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true) // 특정 주소 접근시 권한 및 인증을 위한 어노테이션 활성화
public class SecurityConfig {// 애가 필터 체인임
	

    
   @Bean
    public RequestContextFilter requestContextFilter() {
        return new RequestContextFilter();
    }
	/*
	* 스프링 시큐리티 룰을 무시할 URL 규칙 설정
	* 정적 자원에 대해서는 Security 설정을 적용하지 않음
	*/ 
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			.antMatchers("/resources/**")
			.antMatchers("/css/**")
			.antMatchers("/vendor/**")
			.antMatchers("/js/**")
			.antMatchers("/favicon*/**")
			.antMatchers("/img/**");
	}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable(); //csrf 비활성화 하자
		http.authorizeRequests() //여기에 들어가
			.antMatchers("/team/create").authenticated() // 이주소로 가면 인증 필여해!!
			//.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')") 여기는 롤이 이거여야해!
			//.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_USER')")
			//.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.anyRequest().permitAll() //나머지 request는 전부 허가한다.
		.and() //그리고
	        .exceptionHandling()
	        .authenticationEntryPoint(unauthorizedEntryPoint()) // 인증되지 않은 사용자의 접근 시 에러 처리
	        .and()
			.formLogin() //로그인 관련 처리
			//.loginPage("/login") // 설정 권한 없는 페이지 이동 시  여기로 가게 해라
			.usernameParameter("user_id") //우린 dto가 username이 아니기 떄문에 바꿔줘야 함
			.passwordParameter("user_password")
			.loginProcessingUrl("/kfc/login") //이 주소가 호출되면 시큐리티가 낚아챈다!
	        .successHandler(customAuthenticationSuccessHandler())
	        .failureHandler(customAuthenticationFailureHandler())
			//.defaultSuccessUrl("http://localhost:8080/")//로그인 완료 시 페이지 이동 rest에선 안썻브ㅏㄹ
		.and()
		.logout() // 로그아웃 관련 처리
		.logoutUrl("/logout") // 로그아웃 URL 설정
		.invalidateHttpSession(true) // 로그아웃 후 세션 초기화 설정
		.deleteCookies("JSESSIONID")// 로그아웃 후 쿠기 삭제 설정
		.logoutSuccessHandler((request, response, authentication) -> {
			//중복 로그인 방지를 위해 로그아웃시 로그인상태를 false로 변경
			
		    // 로그아웃 성공 후 데이터 반환 처리
		    // 반환하려는 데이터를 설정하고, 적절한 HTTP 상태 코드 및 헤더를 설정할 수 있습니다.
		    response.setStatus(HttpServletResponse.SC_OK);
		    response.setContentType("application/json");
		    response.getWriter().write("{ \"message\": \"success\" }");

		})
		//.logoutSuccessUrl("/") // 로그아웃 성공 후 이동할 URL 설정 이것도 rest에선 못썻ㅂ
		.and()
		.cors()
		.and()
		.sessionManagement()
     		.maximumSessions(1) // 동시 세션 제한 설정
     		.sessionRegistry(sessionRegistry())
     		.maxSessionsPreventsLogin(false)
     	    .and()
     	.and()
		.addFilterBefore(requestContextFilter(), UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }
    
    //동시세션 방지를 위해
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addListener(new HttpSessionEventPublisher());
    }
    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }
    @Bean
    public ConcurrentSessionControlAuthenticationStrategy sessionAuthenticationStrategy() {
        return new ConcurrentSessionControlAuthenticationStrategy(sessionRegistry());
    }
    
    
    @Bean
    public AuthenticationEntryPoint unauthorizedEntryPoint() {
        return (request, response, authException) -> {
            try {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            } catch (IOException e) {
                throw new ServletException(e);
            }
        };
    }
   //암호화 
	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	//cors설정
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();

		configuration.setAllowedOriginPatterns(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("HEAD","POST","GET","DELETE","PUT"));
		configuration.setAllowedHeaders(Arrays.asList("*"));
		configuration.addAllowedOrigin("http://localhost:8080");
		configuration.setAllowCredentials(true);
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	//로그인 성공 시
    @Bean
    public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    } //로그인 실패 시
    @Bean
    public AuthenticationFailureHandler customAuthenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }


}
