package com.mysite.petsonal.user;

import com.mysite.petsonal.role.MemberRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SiteUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true) // 유일한 값만 저장. 값을 중복되게 저장할 수 없음
	private String username;

	private String password;

	@Column(unique = true)
	private String email;

	@Enumerated(EnumType.STRING)
	private MemberRole role;

	public boolean isAdmin() {
		return MemberRole.ADMIN.equals(this.role);
	}

	public MemberRole getRole() {
		return role;
	}

	public void setRole(MemberRole role) {
		this.role = role;
	}

}
