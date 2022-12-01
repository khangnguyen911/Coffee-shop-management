package com.tdtu.THANH19.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("accounts")
public class AccountController {
	@GetMapping("register")
	public String getRegister() {
		return "accounts/register";
	}
	
	@GetMapping("login")
	public String getLogin() {
		return "accounts/login";
	}
	
	@GetMapping("logout")
	public String getLogout() {
		return "accounts/logout";
	}
}
