package com.mysite.petsonal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysite.petsonal.user.*;

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
	
	@GetMapping("/pro_detail")
	public String pro_datail() {
		return "pro_detail";
	}
	
	
	
	@GetMapping("/hoodies")
	public String hoodies() {
		return "hoodies";
	}
	
	
	@GetMapping("/FaQ")
	public String FaQ() {
		return "FaQ";
	}
	
	
	@GetMapping("/size/outcome")
	public String SizeOutcome() {
		return "Size_outcome";
	}
	
	
	
	@GetMapping("/signup")
	public String signup(UserCreateForm userCreateForm) {
		return "signup_form";
	}
	


	
}
