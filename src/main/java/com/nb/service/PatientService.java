package com.nb.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.nb.Entity.Patient;
import com.nb.Entity.Query;
import com.nb.dto.PatientResponseDTO;
import com.nb.dto.QueryRequestDto;
import com.nb.repository.PatientRepository;
import com.nb.repository.QueryRepository;

import java.util.ArrayList;
import java.util.List;

import com.nb.Entity.Query;
import com.nb.dto.QueryResponseDto;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final QueryRepository queryRepository;

    public PatientService(PatientRepository patientRepository,
                          QueryRepository queryRepository) {
        this.patientRepository = patientRepository;
        this.queryRepository = queryRepository;
    }

    // Get Logged-in Patient Profile
    public PatientResponseDTO getCurrentPatientProfile() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        Patient patient = patientRepository.findByUserEmail(email)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        PatientResponseDTO dto = new PatientResponseDTO();

        dto.setId(patient.getId());
        dto.setName(patient.getUser().getName());
        dto.setEmail(patient.getUser().getEmail());
        dto.setPhone(patient.getPhone());
        dto.setGender(patient.getGender());
        dto.setBloodGroup(patient.getBloodGroup());
        dto.setAddress(patient.getAddress());
        dto.setDob(patient.getDob());
        dto.setActive(patient.getUser().isActive());
        dto.setCreatedAt(patient.getUser().getCreatedAt());

        return dto;
    }

    // Save Patient Query
    public void saveQuery(QueryRequestDto requestDto) {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        Patient patient = patientRepository.findByUserEmail(email)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Query query = new Query();

        query.setSubject(requestDto.getSubject());
        query.setDescription(requestDto.getDescription());

        query.setPatient(patient);

        queryRepository.save(query);
    }
    
    
    public List<QueryResponseDto> getMyQueries() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        Patient patient = patientRepository.findByUserEmail(email)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        List<Query> queries = queryRepository.findByPatient(patient);

        List<QueryResponseDto> response = new ArrayList<>();

        for (Query query : queries) {

            QueryResponseDto dto = new QueryResponseDto();

            dto.setId(query.getId());
            dto.setSubject(query.getSubject());
            dto.setDescription(query.getDescription());
            dto.setDoctorReply(query.getDoctorReply());
            dto.setStatus(query.getStatus());
            dto.setCreatedAt(query.getCreatedAt());

            response.add(dto);
        }

        return response;
    }
    
    

}