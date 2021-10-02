package com.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.entity.UserEntity;
import com.repository.UserRepository;

public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserEntity user = userRepo.findByUsername(username);
//		if (user != null) {
//			return null;
//		}
//		throw new UsernameNotFoundException("Invalid credentials");
//	

		if (user != null) {
			return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
		}
		throw new UsernameNotFoundException("Invalid Credentials");
	}

}
