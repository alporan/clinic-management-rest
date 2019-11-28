package com.orana.clinicmanagementrest.repository;

import com.orana.clinicmanagementrest.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> { }
