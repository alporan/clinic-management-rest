package com.orana.clinicmanagementrest.repository;

import com.orana.clinicmanagementrest.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> { }