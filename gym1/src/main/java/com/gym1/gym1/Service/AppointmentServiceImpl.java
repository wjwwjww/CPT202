package com.gym1.gym1.Service;

import com.gym1.gym1.Model.Appointment;
import com.gym1.gym1.Model.User;
import com.gym1.gym1.Repository.AppointmentRepo;
import com.gym1.gym1.Repository.trainerrepo;
import com.gym1.gym1.Repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepository;
    @Autowired
    private userRepo userepo;
    @Autowired
    private trainerrepo trainerRepo;

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> getAppointmentByuserId(Integer id) {
        return appointmentRepository.findAppointmentByuserid(id);
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {
        try{

        LocalDateTime start = appointment.getAppointmentTime();
        LocalDateTime end = start.plusMinutes(appointment.getDuration());
        int userid=appointment.getUser().getuserId();
        int trainerid=appointment.getTrainer().gettrainerId();
        List<Appointment> conflictingAppointments = appointmentRepository.findByUserAndAppointmentTimeBetween(appointment.getUser(), start, end);
        List<Appointment> conflictingAppointments2 = appointmentRepository.findByTrainerAndAppointmentTimeBetween(appointment.getTrainer(), start,end);
        List<Appointment> conflictingAppointments3 = appointmentRepository.findByUserAndAppointmentTimeBetween(appointment.getUser(), start);
        List<Appointment> conflictingAppointments4 = appointmentRepository.findByTrainerAndAppointmentTimeBetween(appointment.getTrainer(), start);
        List<Appointment> conflictingAppointments5 = appointmentRepository.findByUserAndAppointmentTimeBetween(appointment.getUser(), end);
        List<Appointment> conflictingAppointments6 = appointmentRepository.findByTrainerAndAppointmentTimeBetween(appointment.getTrainer(), end);
            List<Appointment> existingAppointments7 = appointmentRepository.findByUserAppointmentTimesame(appointment.getUser(),start, end);
            if(!existingAppointments7.isEmpty()){
                throw new RuntimeException("预约时间与现有预约冲突，请选择其他时间。");
            }
        if (!conflictingAppointments.isEmpty()||!conflictingAppointments2.isEmpty()||!conflictingAppointments3.isEmpty()||!conflictingAppointments4.isEmpty()||!conflictingAppointments5.isEmpty()||!conflictingAppointments6.isEmpty()) {
            throw new RuntimeException("预约时间与现有预约冲突，请选择其他时间。");
        }
        }
        catch (Exception e){
            throw new RuntimeException("预约时间与现有预约冲突，请选择其他时间。");
        }

        return appointmentRepository.save(appointment);
    }





    @Override
    public void deleteAppointment(int id) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
        if (appointmentOptional.isPresent()) {
            appointmentRepository.delete(appointmentOptional.get());
            System.out.println("预约已删除");
        } else {
            // 如果预约不存在，抛出异常或提供其他反馈
            throw new RuntimeException("找不到指定的预约");
        }
    }


    @Override
    public void updateAppointment(Appointment updatedAppointment) {
   int id= updatedAppointment.getId();
     Appointment   originalAppointment= appointmentRepository.findById(id).get();
        updatedAppointment.setUser(appointmentRepository.findById(id).get().getUser());
   updatedAppointment.setCreateTime(appointmentRepository.findById(id).get().getCreateTime());
   updatedAppointment.setRating(appointmentRepository.findById(id).get().getRating());
 try {
        deleteAppointment(updatedAppointment.getId());
        createAppointment(updatedAppointment);

 }
    catch (Exception e) {
        // 出现错误时，尝试恢复原始预约数据
        appointmentRepository.save(originalAppointment);
        throw new RuntimeException("更新预约失败");
    }
    }




    @Override
    public List<Appointment> getAppointmentsByid(Integer id) {
        return appointmentRepository.findAppointmentByid(id);
    }

    @Override
    public List<Appointment> getAppointmentByTrainerId(Integer id) {
        return appointmentRepository.findappointmentBytrainerid(id);
    }
}