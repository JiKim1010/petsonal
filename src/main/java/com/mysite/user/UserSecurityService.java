package com.mysite.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


// 사용자 정보를 폼에서 넘겨 받아서 인증을 처리함


@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {
	// UserDetailsService 는 loadUserByUsername 메서드를 구현하도록 강제하는 인터페이스
	// UserSecurityService 는 스프링 시큐리티 로그인 처리의 핵심 부분

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// loadUserByUsername 메서드는 사용자명으로 비밀번호를 조회하여 리턴하는 메서드


		Optional<SiteUser> _siteUser = this.userRepository.findByusername(username);

			
		if (_siteUser.isEmpty()) {
			throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");
		}
		
		
		// 폼에서 넘어오는 username을 DB에서 쿼리해서 siteUser 객체에 담은 값을 Optional 에서 뽑아옴
		// siteUser : DB에서 select 한 레코드
		SiteUser siteUser = _siteUser.get();
		
		
		// Authentication(인증) : Identity (ID) + Password를 확인하는 것
		// Authorization (허가) : 인증된 사용자에게 사이트의 서비스를 쓸 수 있도록 권한을 부여하는 것
			// 계정이 admin 이라면 ADMIN Role을 적용
			// 계정이 admin 이 아니라면 USER Role을 적용
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		if ("admin".equals(username)) {
			
			// 사용자명이 "admin"인 경우에는 ADMIN 권한을 부여. 그 이외의 경우에는 USER 권한을 부여
			authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
	
		} else {
		
			authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
		}
		return new User(siteUser.getUsername(), siteUser.getPassword(), authorities);
	}

	/*
	스프링 시큐리티에 등록하여 사용할 UserSecuritySe
	 
	 
	*/
	
	
	
	
	
}
