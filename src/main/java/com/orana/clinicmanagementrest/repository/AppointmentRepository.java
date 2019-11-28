package com.orana.clinicmanagementrest.repository;

import com.orana.clinicmanagementrest.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> { }