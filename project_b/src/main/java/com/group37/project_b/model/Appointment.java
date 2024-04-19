package com.group37.project_b.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int customerID;
    private int trainerID;
    private int status; // 0 - new, 1 - completed, 2 - cancelled
    private int rating;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;


    public Appointment() {
    }


    public Appointment(int id, int customerID, int trainerID, int status, int rating, LocalDate appointmentDate,
            LocalTime appointmentTime) {
        this.id = id;
        this.customerID = customerID;
        this.trainerID = trainerID;
        this.status = status;
        this.rating = rating;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getCustomerID() {
        return customerID;
    }


    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }


    public int getTrainerID() {
        return trainerID;
    }


    public void setTrainerID(int trainerID) {
        this.trainerID = trainerID;
    }


    public int getStatus() {
        return status;
    }


    public void setStatus(int status) {
        this.status = status;
    }


    public int getRating() {
        return rating;
    }


    public void setRating(int rating) {
        this.rating = rating;
    }


    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }


    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }


    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }


    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    
    
}
