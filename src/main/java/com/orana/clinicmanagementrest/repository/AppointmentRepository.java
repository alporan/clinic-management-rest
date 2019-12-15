package com.orana.clinicmanagementrest.repository;

import com.orana.clinicmanagementrest.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctorId(Long doctorID);
    List<Appointment> findByPatientId(Long patientID);
    Optional<Appointment> findByIdAndDoctorId(Long id, Long instructorId);
}