package com.nb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nb.Entity.Patient;
import com.nb.Entity.Query;

public interface QueryRepository extends JpaRepository<Query, Long> {

    List<Query> findByPatient(Patient patient);
    List<Query> findByStatus(String status);
    long countByStatus(String status);

}