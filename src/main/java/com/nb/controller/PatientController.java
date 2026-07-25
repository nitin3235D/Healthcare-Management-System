package com.nb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nb.Entity.User;
import com.nb.dto.RegisterRequestDto;
import com.nb.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	
	@Autowired
	    private UserService userService;

	    @PostMapping("/register")
	    public User register(@Valid @RequestBody RegisterRequestDto request){

	        return userService.registerUser(request);

	    }
	
	    @GetMapping("/test")
	    public String test() {

	        return "Patient API Access Successfully";

	    }

}
