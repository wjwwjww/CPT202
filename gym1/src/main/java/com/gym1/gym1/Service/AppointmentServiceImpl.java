package com.gym1.gym1.Service;

import com.gym1.gym1.Model.Appointment;
import com.gym1.gym1.Model.User;
import com.gym1.gym1.Repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepo appointmentRepo;

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepo.findAll();
    }

    @Override
    public Optional<Appointment> getAppointmentById(Integer id) {
        return appointmentRepo.findById(id);
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    @Override
    public void deleteAppointment(long id) {
        Optional<Appointment> appointment = appointmentRepo.findById(id);
        appointment.ifPresent(value -> appointmentRepo.delete(value));
    }


    @Override
    public void updateAppointment(Appointment updatedAppointment) {
        // 通过唯一标识符（ID）获取待更新的预约信息
        Optional<Appointment> existingAppointment = appointmentRepo.findById(updatedAppointment.getId());
        existingAppointment.ifPresent(appointment -> {
            // 验证更新后的时间有效性
            if (isValidDateTime(updatedAppointment.getAppointmentTime())) {
                // 更新需要修改的字段
                appointment.setAppointmentTime(updatedAppointment.getAppointmentTime());
                appointment.setTrainer(updatedAppointment.getTrainer());
                // 保存更新后的预约信息
                appointmentRepo.save(appointment);
            } else {
                // 时间无效，可以选择抛出异常或进行其他处理
                // 这里仅打印错误消息
                System.err.println("Invalid appointment time: " + updatedAppointment.getAppointmentTime());
            }
        });
    }

    // 辅助方法：验证预约时间有效性
    private boolean isValidDateTime(LocalDateTime dateTime) {
        // 在此添加适当的时间验证逻辑
        // 例如，检查时间是否在当前时间之后
        return dateTime != null && !dateTime.isBefore(LocalDateTime.now());
    }



    @Override
    public List<Appointment> getAppointmentsByUsername(User user) {
        return appointmentRepo.findAppointmentByUser(user);
    }
}
