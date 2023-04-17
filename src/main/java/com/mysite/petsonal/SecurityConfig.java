package com.mysite.petsonal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

@Configuration // Security의 설정을 적용하는 어노테이션
@EnableWebSecurity 	// http의 URL 접근을 제어하는 어노테이션
					// 모든 요청 URL 이 스프링시큐리티의 제어를 받도록 만든다.
					// 내부적으로 SpringSecurityFilterChain 이 동작하여 URL 필터가 적용
@EnableMethodSecurity(prePostEnabled = true)
	//

public class SecurityConfig {
	
	@Bean
	
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests().requestMatchers(
				 
				// Spring Security 에서 모든 URL에서 인증 없이 접근 할 수 있도록 허용
					new AntPathRequestMatcher("/**")).permitAll()	// URL 요청의 퍼밋하겠다
		
		
		// H2 DataBase는 http로 통신하는 DataVase이므로 csrf 적용되지 않도록 설정
				.and()
					.csrf().ignoringRequestMatchers(
						new AntPathRequestMatcher("/h2-console/**"))
					
				.and()
					.headers()
					.addHeaderWriter(
						new XFrameOptionsHeaderWriter(
								XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))

					
			// 스프링 시큐리티의 로그인 처리 
				.and()
					.formLogin()
					.loginPage("/user/login")	// 폼으로 넘어올때 처리
					.defaultSuccessUrl("/") 	// 로그인 성공시 세션에 로그인 정보를 담고
												// 페이지로 이동
			
					
//			// 스프링 시큐리티의 로그아웃 처리
				.and()
					 .logout()
					 .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
					 .logoutSuccessUrl("/")
					 .invalidateHttpSession(true)	//세션에 담긴 모든 값을 삭제헤라
					 ;
			
		return http.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	 AuthenticationManager authenticationManager(AuthenticationConfiguration 
			 authenticationConfiguration) throws Exception {
	//  AuthenticationManager: 스프링 시큐리티의 인증담당
	//  UserSecurityService 와 PasswordEncoder 가 자동으로 설정
		
		/*
		 AuthenticationManager 빈을 생성
		 AuthenticationManager 스프링 시큐리티의 인증담당
		 AuthenticationManager 빈 생성시 스프링의 내부 동작으로 인해 위해서 작성한
		 AuthenticationManager 
		
		 * */
		
		
		
		
	 return authenticationConfiguration.getAuthenticationManager();
	 }
	
	}
	
	


