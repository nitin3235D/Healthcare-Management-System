package com.nb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nb.Entity.Doctor;
import com.nb.Entity.User;
import com.nb.dto.DoctorProfileResponseDto;
import com.nb.dto.DoctorRequestDto;
import com.nb.repository.DoctorRepository;
import com.nb.repository.UserRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    
    
    public Doctor addDoctor(DoctorRequestDto request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists.");
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("DOCTOR");

   

        Doctor doctor = new Doctor();

        doctor.setPhone(request.getPhone());
        doctor.setGender(request.getGender());
        doctor.setSpecialization(request.getSpecialization());
        doctor.setQualification(request.getQualification());
        doctor.setExperience(request.getExperience());
        doctor.setAddress(request.getAddress());
        doctor.setUser(user);

        return doctorRepository.save(doctor);
    }
    
    
    
    public DoctorProfileResponseDto getDoctorProfile() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        Doctor doctor = doctorRepository.findByUserEmail(email)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        DoctorProfileResponseDto dto = new DoctorProfileResponseDto();

        dto.setId(doctor.getId());
        dto.setName(doctor.getUser().getName());
        dto.setEmail(doctor.getUser().getEmail());
        dto.setPhone(doctor.getPhone());
        dto.setGender(doctor.getGender());
        dto.setSpecialization(doctor.getSpecialization());
        dto.setQualification(doctor.getQualification());
        dto.setExperience(doctor.getExperience());
        dto.setAddress(doctor.getAddress());

        return dto;
    }
    
}