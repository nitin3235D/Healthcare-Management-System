package com.nb.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatientResponseDTO {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String gender;

    private String bloodGroup;

    private String address;

    private LocalDate dob;

    private boolean active;

    private LocalDateTime createdAt;

}