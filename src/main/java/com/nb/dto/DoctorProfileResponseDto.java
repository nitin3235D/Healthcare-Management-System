package com.nb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DoctorProfileResponseDto {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String gender;

    private String specialization;

    private String qualification;

    private Integer experience;

    private String address;
}