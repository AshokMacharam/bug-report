package com.bug.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bug.report.dto.LoginRequest;
import com.bug.report.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/")
	public String login(@RequestBody LoginRequest loginRequest) {

		return loginService.login(loginRequest);
	}
	

}
