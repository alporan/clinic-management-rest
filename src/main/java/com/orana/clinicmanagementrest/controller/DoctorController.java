package com.orana.clinicmanagementrest.controller;

import com.orana.clinicmanagementrest.model.Doctor;
import com.orana.clinicmanagementrest.repository.DoctorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/doctors"})
public class DoctorController {

    private DoctorRepository repository;

    DoctorController(DoctorRepository contactRepository) {
        this.repository = contactRepository;
    }

    @GetMapping
    public List findAll(){
        return repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Doctor> findById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Doctor create(@RequestBody Doctor contact){
        return repository.save(contact);
    }

/*    @PutMapping(value="/{id}")
    public ResponseEntity<Doctor> update(@PathVariable("id") long id,
                                          @RequestBody Doctor contact){
        return repository.findById(id)
                .map(record -> {
                    record.setName(contact.getName());
                    record.setEmail(contact.getEmail());
                    record.setPhone(contact.getPhone());
                    Contact updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }*/

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}