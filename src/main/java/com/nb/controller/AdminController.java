package com.nb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.nb.Entity.Doctor;
import com.nb.dto.DoctorRequestDto;
import com.nb.service.DoctorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
@Validated
public class AdminController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/add-doctor")
    public ResponseEntity<Doctor> addDoctor(@Valid @RequestBody DoctorRequestDto request) {

        Doctor doctor = doctorService.addDoctor(request);

        return new ResponseEntity<>(doctor, HttpStatus.CREATED);
    }
}