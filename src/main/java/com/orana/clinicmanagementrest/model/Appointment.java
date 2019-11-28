package com.orana.clinicmanagementrest.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "doctor")
public class Appointment {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private Long patientId;
    @NotBlank
    private Long doctorId;
    @NotBlank
    private Date appointmentDate;

    public Appointment() {
        super();
    }

    public Appointment(@NotBlank Long patientId, @NotBlank Long doctorId, @NotBlank Date appointmentDate) {
        super();
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
