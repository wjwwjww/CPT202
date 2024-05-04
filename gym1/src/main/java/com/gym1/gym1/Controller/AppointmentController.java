package com.gym1.gym1.Controller;

import com.gym1.gym1.Model.Appointment;
import com.gym1.gym1.Model.Trainer;
import com.gym1.gym1.Repository.AppointmentRepo;
import com.gym1.gym1.Repository.userRepo;
import com.gym1.gym1.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AppointmentController {

    @Autowired
    private AppointmentRepo appointmentRepo;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PlanService planService;
    @Autowired
    private TrainerService trainerServicel;
    @Autowired
    private UserAndPlanService userAndPlanService;
    @Autowired
    private UseService useService;
@Autowired
private userRepo userrepo;
    @PostMapping("/submit")
    public ResponseEntity<?> createAppointment(@RequestBody Appointment appointment) {
//        System.out.println("appointment time"+appointment.getAppointmentTime());
//
//        appointment.setCreateTime(LocalDateTime.now());
//        System.out.println("Create time"+appointment.getCreateTime());
        try{
        Appointment createdAppointment = appointmentService.createAppointment(appointment);
        return ResponseEntity.ok(createdAppointment);}
        catch (Exception e){
            String errorMessage = "无法创建预约：" + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @GetMapping("/rating/{email}")
    public ResponseEntity<?> getRatingFromEmail(@PathVariable String email) {
    Integer rating= planService.getratingfromemail(email);
        return ResponseEntity.ok(rating);
    }

    @GetMapping("/idid/{email}")
    public ResponseEntity<?> getidfromid(@PathVariable String email){
     Integer id= userAndPlanService.getidFromid(userrepo.getUserIdByEmail(email));
        return ResponseEntity.ok(id);
    }

    @GetMapping("/trainer/{rating}")
    public List<Trainer> gettrainerbyrating(@PathVariable Integer rating){
        return trainerServicel.getTrainersByrating(rating);
    }
   @GetMapping("/trainerbyemail/{email}")
    public List<Trainer> gettrainerbyemail(@PathVariable String email){
       return trainerServicel.getTrainersByrating(planService.getratingfromemail(email));
    }
    @GetMapping("/getall/{id}")
    public List<Appointment> getallbyid(@PathVariable Integer id){
        return appointmentService.getAppointmentByuserId(id);
    }
    @PostMapping("/updateappointment")
    public ResponseEntity<?> updateAppointment(@RequestBody Appointment appointmentDTO) {
        // 检查是否存在该预约信息
        Optional<Appointment> existingAppointment = appointmentRepo.findById(appointmentDTO.getId());
        if (existingAppointment.isPresent()) {
            // 存在该预约信息，调用服务层方法更新预约信息

            appointmentService.updateAppointment(appointmentDTO);
            return ResponseEntity.ok("预约信息已成功更新");
        } else {
            // 不存在该预约信息，返回错误响应
            return ResponseEntity.ok("appointment not found"+appointmentDTO.getId());
        }

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAppointment(
            @PathVariable("id") int id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.ok().build();
    }
}

