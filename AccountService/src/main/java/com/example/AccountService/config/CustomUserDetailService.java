package com.example.AccountService.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.AccountService.entity.Account;
import com.example.AccountService.repository.AccountRepository;

@Component
public class CustomUserDetailService implements UserDetailsService{
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Account> account = accountRepository.finfByUsername(username);
		return account.map(CustomUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("Not found username: "+username));
	}
	
	
}
