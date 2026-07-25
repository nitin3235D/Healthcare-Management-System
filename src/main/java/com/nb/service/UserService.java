package com.nb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nb.Entity.User;
import com.nb.dto.RegisterRequestDto;
import com.nb.repository.UserRepository;
import com.nb.Entity.Patient;
import com.nb.repository.PatientRepository;


@Service
public class UserService {

	private final UserRepository userRepository;
	private final PatientRepository patientRepository;

	
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public UserService(BCryptPasswordEncoder bCryptPasswordEncoder
			,PatientRepository patientRepository, UserRepository userRepository) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userRepository = userRepository;
		this.patientRepository = patientRepository;
	}
	
	

	public User registerUser(RegisterRequestDto request) {

	    Optional<User> existingUser =
	            userRepository.findByEmail(request.getEmail());

	    if (existingUser.isPresent()) {
	        throw new RuntimeException("Email already registered.");
	    }

	    User user = new User();

	    user.setName(request.getName());
	    user.setEmail(request.getEmail());
	    user.setPassword(
	            bCryptPasswordEncoder.encode(request.getPassword()));
	    user.setRole("PATIENT");
	    
	    
	    Patient patient = new Patient();
	    
        patient.setPhone(request.getPhone());
        patient.setGender(request.getGender());
        patient.setBloodGroup(request.getBloodGroup());
        patient.setAddress(request.getAddress());
        patient.setDob(request.getDob());
        patient.setUser(user);

	    patientRepository.save(patient);

	    return user;
	}

}
