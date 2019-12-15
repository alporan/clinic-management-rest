package com.orana.clinicmanagementrest.controller;

import com.orana.clinicmanagementrest.model.Appointment;
import com.orana.clinicmanagementrest.model.Doctor;
import com.orana.clinicmanagementrest.model.Patient;
import com.orana.clinicmanagementrest.repository.AppointmentRepository;
import com.orana.clinicmanagementrest.repository.DoctorRepository;
import com.orana.clinicmanagementrest.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class AppointmentController {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @GetMapping("/appointments/{id}")
    public ResponseEntity<Appointment> findById(@PathVariable(value = "id") long id){
        return appointmentRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/doctors/{doctorId}/appointments")
    public List<Appointment> getAllAppointmentsByDoctorId(@PathVariable (value = "doctorId") Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    @GetMapping("/patients/{patientId}/appointments")
    public List<Appointment> getAllAppointmentsByPatientId(@PathVariable (value = "patientId") Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    @PostMapping("/doctors/{doctorId}/patients/{patientId}")
    public Appointment createAppointment(@PathVariable(value = "doctorId") Long doctorId, @PathVariable(value = "patientId") Long patientId,
                               @Valid @RequestBody Appointment appointment) throws InvalidConfigurationPropertyValueException {
        @Valid Appointment aaappointment = patientRepository.findById(patientId).map(patient -> {
            appointment.setPatient(patient);
            return appointment;
        }).orElseThrow(() -> new InvalidConfigurationPropertyValueException("aaA", "instructor not found", null));

        return doctorRepository.findById(doctorId).map(doctor -> {
            aaappointment.setDoctor(doctor);
            return appointmentRepository.save(aaappointment);
        }).orElseThrow(() -> new InvalidConfigurationPropertyValueException("aaA", "instructor not found", null));
    }


    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return appointmentRepository.findById(id)
                .map(record -> {
                    appointmentRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
