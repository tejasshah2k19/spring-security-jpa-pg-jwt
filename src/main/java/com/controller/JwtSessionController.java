package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.UserDTO;
import com.entity.UserEntity;
import com.repository.UserRepository;

@RestController
public class JwtSessionController {

	@Autowired
	UserRepository userRepo;

	@Autowired
	PasswordEncoder passwordEncoder;

	@PostMapping("/signup")
	public ResponseEntity<UserEntity> signup(@RequestBody UserEntity user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepo.save(user);
		return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody UserDTO user) {

		
		
		return null;
	}

}
