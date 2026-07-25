package com.nb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nb.Entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}
