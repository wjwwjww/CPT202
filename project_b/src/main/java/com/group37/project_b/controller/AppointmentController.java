package com.group37.project_b.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.group37.project_b.model.Appointment;
import com.group37.project_b.repository.AppointmentRepo;
;


@Controller
public class AppointmentController {
    @Autowired
    private AppointmentRepo appointmentRepo;

    @GetMapping("/api/appointments")
    public List<Appointment> getAppointments(){
        return appointmentRepo.findAll();
    }

    @GetMapping("/Appointments_Management")
    public String getAppointmentsManagementPage(Model m) {
        List<Appointment> Appointments = appointmentRepo.findAll();
        m.addAttribute("Appointments", Appointments);
        
        int counter = 0;
        int totalRating = 0;
        for(Appointment a: Appointments){
            if(a.getAppointmentDate().until(LocalDate.now(), ChronoUnit.DAYS) <= 31){
                counter++;
                totalRating += a.getRating();
            }
        }
        double avgRating = (double) totalRating/counter;
        m.addAttribute("NoAppointmentRecentMonth", counter);
        m.addAttribute("AvgRating", avgRating);

        return "AppointmentsManagement";
    }
    
}
 