package com.nb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nb.dto.DoctorProfileResponseDto;
import com.nb.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/profile")
    public ResponseEntity<DoctorProfileResponseDto> getDoctorProfile() {

        DoctorProfileResponseDto doctorProfile = doctorService.getDoctorProfile();

        return ResponseEntity.ok(doctorProfile);
    }

}