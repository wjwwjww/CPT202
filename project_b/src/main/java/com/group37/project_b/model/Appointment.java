package com.group37.project_b.model;

import java.time.LocalDateTime;


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
    private LocalDateTime appointmentTime;
    private int duration;   //in minutes


    public Appointment() {
    }


    public Appointment(int id, int customerID, int trainerID, int status, int rating, LocalDateTime appointmentTime,
    int duration) {
        this.id = id;
        this.customerID = customerID;
        this.trainerID = trainerID;
        this.status = status;
        this.rating = rating;
        this.appointmentTime = appointmentTime;
        this.duration = duration;
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

    public String getStatusText() {
        if(this.status==0){
            return "UNCOMPLETED";
        }
        else if(this.status==1){
            return "COMPLETED";
        }
        else if(this.status==2){
            return "CANCELLED";
        }
        return "ERROR";
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


    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }


    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }


    public int getDuration() {
        return duration;
    }


    public void setDuration(int duration) {
        this.duration = duration;
    }


    public LocalDateTime getAppointmentEndTime(){
        return this.appointmentTime.plusMinutes(this.duration);
    }

    
    
}
