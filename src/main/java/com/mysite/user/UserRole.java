package com.mysite.user;

import lombok.Getter;


@Getter		// 상수 자료형이므로 @Setter 없이 @Getter만 사용가능
public enum UserRole { //열거 자료형(enum)
	
	ADMIN("ROLE_ADMIN"),
	USER("ROLE_USER");
	
	UserRole(String value){
		this.value = value;
	}
	
	private String value;
	
}
