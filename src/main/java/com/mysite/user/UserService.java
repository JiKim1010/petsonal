package com.mysite.user;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public SiteUser create(String username, String email, String password) {

		SiteUser user = new SiteUser();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(passwordEncoder.encode(password));

		this.userRepository.save(user);
		return user;
	}
//
//	public SiteUser getUser(String username) {
//		// User 서비스를 통해 SiteUser 를 조회할 수 있는 getUser 메서드를 UserService 에 추가
//
//		Optional<SiteUser> siteUser = this.userRepository.findByusername(username);
//
//		if (siteUser.isPresent()) {
//
//			return siteUser.get();
//
//		} else {
//			throw new DataNotFoundException("siteuser not found");
//		}
//
//	}

}
