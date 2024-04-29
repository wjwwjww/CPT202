package com.gym1.gym1.Repository;

import com.gym1.gym1.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gym1.gym1.Model.Appointment;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {

//    @Query("SELECT a FROM Appointment a WHERE a.username = ?1")
//    Optional<Appointment> findByUsername(String username);
    @Query("SELECT a FROM Appointment a WHERE a.user = ?1")
    List<Appointment> findAppointmentByUser(User user);
//    @Query("SELECT a FROM Appointment a WHERE a.username = :username AND a.date = :date AND a.time = :time AND a.trainer = :trainer")
//    Optional<Appointment> findByUsernameAndDateAndTimeAndTrainer(String username, String date, String time, String trainer);
    @Query("SELECT a FROM Appointment a WHERE a.id = ?1")
    Optional<Appointment> findById(Long id);



}
