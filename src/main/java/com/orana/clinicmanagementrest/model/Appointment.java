package com.orana.clinicmanagementrest.model;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotBlank
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Patient patient;

    @NotBlank
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Doctor doctor;

    @NotBlank
    private Date appointmentDate;

    public Appointment() {
        super();
    }

    public Appointment(@NotBlank Date appointmentDate) {
        super();
        this.appointmentDate = appointmentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getInstructor() {
        return doctor;
    }

    public void setInstructor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
