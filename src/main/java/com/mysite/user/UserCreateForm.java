package com.mysite.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateForm {
	
	@Size(min=3, max=25)
	@NotEmpty(message="사용자 ID는 필수항목입니다. ")
	private String username; // client에서 보내는 네임변수와 동일해야 setter에서 받을 수 있다.
	
	@NotEmpty(message="비밀번호는 필수항목입니다. ")
	private String password1; 
	
	@NotEmpty(message="비밀번호 확인 필수항목입니다. ")
	private String password2;
	
	@Email
	@NotEmpty(message="이메일은 필수항목입니다. ")
	private String email;

	
}
