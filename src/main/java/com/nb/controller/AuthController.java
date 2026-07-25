package com.nb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nb.Entity.User;
import com.nb.dto.RegisterRequestDto;
import com.nb.dto.loginRequest;
import com.nb.service.AuthenticationService;
import com.nb.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

	
	
	@Autowired
	private AuthenticationService authenticationService;


	
	@PostMapping("/login")
	public ResponseEntity<String> login(@Valid @RequestBody loginRequest loginRequest){
		
		String token = authenticationService.authenticate(loginRequest);
		
		return  ResponseEntity.ok(token);
	}
	

}
