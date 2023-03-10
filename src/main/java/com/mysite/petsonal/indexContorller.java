package com.mysite.petsonal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mysite.user.UserCreateForm;

@Controller
public class indexContorller {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/size")
	public String size() {
		return "size";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/detail")
	public String datail() {
		return "datail";
	}
	
	@GetMapping("/signup")
	public String signup(UserCreateForm userCreateForm) {
		return "signup_form";
	}
	

	
}
