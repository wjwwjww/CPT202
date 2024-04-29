package com.gym1.gym1.Service;

import com.gym1.gym1.Model.Appointment;
import com.gym1.gym1.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface AppointmentService {

    // 查看所有预约
    List<Appointment> getAllAppointments();

    // 根据用户名查看预约详情
    Optional<Appointment> getAppointmentById(Integer id);

    // 创建预约
    Appointment createAppointment(Appointment appointment);


    // 删除预约
    void deleteAppointment(long id);

    // 更新预约
    void updateAppointment(Appointment appointment);


    List<Appointment> getAppointmentsByUsername(User user);


}
