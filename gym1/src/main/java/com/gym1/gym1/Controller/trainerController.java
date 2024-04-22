package com.gym1.gym1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gym1.gym1.Model.Trainer;
import com.gym1.gym1.Repository.trainerrepo;



@Controller
public class trainerController {

    @Autowired
    private trainerrepo trainerrepo;


    @GetMapping("/Trainers_page")
    public String gettrainerPage(Model m) {
        List<Trainer> Trainers = trainerrepo.findAll();
        m.addAttribute("Trainers", Trainers);
        return "main_forTrainer";
    }

    @GetMapping("/add_Trainer")
    public String getAddTrainer(Model model){
        model.addAttribute("Trainer", new Trainer());
        return "addTrainer";
    }

    @PostMapping("/add_Trainer")
    public String postAddTrainer(@ModelAttribute Trainer trainer){
        trainerrepo.save(trainer);

       
        return "success_forTrainer";
    }

    @PostMapping("/trainerLogin")
    public ModelAndView trainerLogin(@RequestParam int trainerId, @RequestParam String trainerPassword) {
        Trainer trainer = trainerrepo.findByTrainerId(trainerId);
        if (trainer != null && trainer.gettrainerPassword().equals(trainerPassword)) {
            // Trainer login successful
            // Redirect or return some response
            return new ModelAndView("redirect:/trainerPage");
        } else {
            // Trainer login failed
            // Redirect back to login page with error message
            ModelAndView modelAndView = new ModelAndView("main_page");
            modelAndView.addObject("trainerLoginError", "Invalid ID or password");
            return modelAndView;
        }
    }




   
   


    @GetMapping("/trainerPage")
    public String AfterTrainerLogin() {
        return "trainerPage";
    }
    
    
}