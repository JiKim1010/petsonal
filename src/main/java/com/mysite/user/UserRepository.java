package com.mysite.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {

	// JPA 는 SQL 쿼리를 사용하지 않고 JPA 메소드가 SQL 쿼리로 변환해서 처리
	
	// findAll()
	// findByID()
	// save()		<=== Insert, Update
	// delete() 	<=== delete
	
	
	
// 로그인 처리하기 위해서 사용자 정보를 입력 받아서 DataBase에서 Select 해서 SiteUser 객체에 저장함
	// select* from site_user where username=?
	// form에서 인풋 받음
	Optional<SiteUser> findByusername(String username);
	// UserSecurityService 는 사용자를 조회하는 기능이 필요하므로 다음처럼
	//findByusername 메서드를 User 리포지터리에 추가
}
