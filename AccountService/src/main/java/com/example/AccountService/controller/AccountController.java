package com.example.AccountService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.AccountService.entity.Account;
import com.example.AccountService.service.AccountService;

@RestController
@RequestMapping("/auth")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@Autowired AuthenticationManager authenticationManager;
	
	@PostMapping("/register")
	public String saveUser(@RequestBody Account account) {
		return accountService.save(account);
	}
	
	@PostMapping("/login")
	public String getToken(@RequestBody Account account) {
		System.out.println("username"+account.getPassword());
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));
		if (authentication.isAuthenticated()) {
			return accountService.generateToken(account.getUsername());
		} else {
			throw new RuntimeException("invalid access");
		}
	}
	
	@GetMapping("/validate")
	public String validateToken(@RequestParam("token") String token) {
		accountService.validateToken(token);
		return "Token is valid";
	}
}
