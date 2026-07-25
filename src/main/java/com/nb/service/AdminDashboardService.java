package com.nb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nb.dto.AdminDashboardResponseDto;
import com.nb.repository.DoctorRepository;
import com.nb.repository.QueryRepository;
import com.nb.repository.UserRepository;

@Service
public class AdminDashboardService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QueryRepository queryRepository;

    public AdminDashboardResponseDto getDashboardData() {

        AdminDashboardResponseDto response = new AdminDashboardResponseDto();

        response.setTotalDoctors(doctorRepository.count());

        response.setTotalPatients(userRepository.countByRole("PATIENT"));

        response.setTotalQueries(queryRepository.count());

        response.setPendingQueries(queryRepository.countByStatus("PENDING"));

        response.setAnsweredQueries(queryRepository.countByStatus("ANSWERED"));

        response.setClosedQueries(queryRepository.countByStatus("CLOSED"));

        return response;
    }

}