package com.orana.clinicmanagementrest.controller;

import com.orana.clinicmanagementrest.model.Patient;
import com.orana.clinicmanagementrest.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient> findById(@PathVariable(value = "id") long id){
        return patientRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/patients")
    public Patient createPatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }


    @DeleteMapping("/patients/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return patientRepository.findById(id)
                .map(record -> {
                    patientRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}