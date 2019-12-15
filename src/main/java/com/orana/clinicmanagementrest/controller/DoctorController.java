package com.orana.clinicmanagementrest.controller;

import com.orana.clinicmanagementrest.model.Doctor;
import com.orana.clinicmanagementrest.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/doctors")
    public List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    }

    @GetMapping("/doctors/{id}")
    public ResponseEntity<Doctor> findById(@PathVariable(value = "id") long id){
        return doctorRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/doctors")
    public Doctor createDoctor(@RequestBody Doctor doctor){
        return doctorRepository.save(doctor);
    }


    @DeleteMapping("/doctors/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return doctorRepository.findById(id)
                .map(record -> {
                    doctorRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}