package com.gym1.gym1.Controller;

import com.gym1.gym1.Model.Plan;
import com.gym1.gym1.Model.User;
import com.gym1.gym1.Model.UserandPlan;
import com.gym1.gym1.Repository.planRepo;
import com.gym1.gym1.Repository.userAndplanRepo;
import com.gym1.gym1.Repository.userRepo;

import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class userController {

    @Autowired
    private userRepo userrepo;

    @Autowired
    private HttpSession session;

    @Autowired
    private HttpSession session1;

    @Autowired
    private planRepo PlanRepo;

    @Autowired 
    private userAndplanRepo UserAndPlanRepo;
    
   
    @GetMapping("/Users_page")
    public String getuserPage(Model m) {
        List<User> Users = userrepo.findAll();
        m.addAttribute("Users", Users);
        return "main";
    }

    @GetMapping("/add_User")
    public String getAddUser(Model model){
        model.addAttribute("User", new User());
        return "addUser";
    }

    @PostMapping("/add_User")
    public String postAddUser(@ModelAttribute User user){
        userrepo.save(user);

       
        return "success";

    
    }
  
    @PostMapping("/userLogin")
    public ModelAndView userLogin(@RequestParam String userEmail, @RequestParam String userPassword) {
        User user = userrepo.findByUserEmail(userEmail);
        if (user != null && user.getuserPassword().equals(userPassword)) {
            // User login successful
            // Redirect or return some response
            session.setAttribute("loggedInUser", user);
            return new ModelAndView("redirect:/UserPage");
        } else {
            // User login failed
            // Redirect back to login page with error message
            ModelAndView modelAndView = new ModelAndView("main_page");
            modelAndView.addObject("userLoginError", "Invalid email or password");
            return modelAndView;
        }
    }

    @GetMapping("/UserPage")
    public String getUserPage() {
      
        return "UserPage";
    }
    
    @GetMapping("/getUserData")
    @ResponseBody
    public Map<String, String> getUserData() {
    Map<String, String> response = new HashMap<>();
    User user = (User) session.getAttribute("loggedInUser");
    if (user != null) {
        response.put("userEmail", user.getuserEmail());
    } else {
        response.put("error", "User not logged in");
    }
    return response;
    }

   





    @GetMapping("/Plan")
    public String getPlan() {
        return "Plan";
    }
    

  

    @GetMapping("/Plan_One")
    public String purchasePlan1(Model model, @ModelAttribute Plan Plan) {
    Plan plan1 = (Plan) PlanRepo.findByPlanId(1);
    session1.setAttribute("PlanOne", plan1);
    model.addAttribute("UserandPlan", new UserandPlan());
    return "sixMonthSilver";
    }

    @GetMapping("/Plan_Two")
    public String purchasePlan2(Model model, @ModelAttribute Plan Plan) {
        Plan plan2 = (Plan) PlanRepo.findByPlanId(2);
        session.setAttribute("PlanTwo", plan2);
        model.addAttribute("UserandPlan", new UserandPlan());
        return "twelMonthSilver";
    }
    @GetMapping("/Plan_Three")
    public String purchasePlan3(Model model, @ModelAttribute Plan Plan) {
        Plan plan3 = (Plan) PlanRepo.findByPlanId(3);
        session.setAttribute("PlanThree", plan3);
        model.addAttribute("UserandPlan", new UserandPlan());
        return "sixMonthGold";
    }
    @GetMapping("/Plan_Four")
    public String purchasePlan4(Model model, @ModelAttribute Plan Plan) {
        Plan plan4 = (Plan) PlanRepo.findByPlanId(4);
        session.setAttribute("PlanFour", plan4);
        model.addAttribute("UserandPlan", new UserandPlan());
        return "twelMonthGold";
    }
    @GetMapping("/Plan_Five")
    public String purchasePlan5(Model model, @ModelAttribute Plan Plan) {
        Plan plan5 = (Plan) PlanRepo.findByPlanId(5);
        session.setAttribute("PlanFive", plan5);
        model.addAttribute("UserandPlan", new UserandPlan());
        return "sixMonthDiamond";
    }
    @GetMapping("/Plan_Six")
    public String purchasePlan6(Model model, @ModelAttribute Plan Plan) {
        Plan plan6 = (Plan) PlanRepo.findByPlanId(6);
        session.setAttribute("PlanSix", plan6);
        model.addAttribute("UserandPlan", new UserandPlan());
        return "twelMonthDiamond";
    }











    @PostMapping("/Plan_One")
    public String postMethodName1(@ModelAttribute UserandPlan userandplan) {
       UserAndPlanRepo.save(userandplan);
        
        return "success_forPlan";
    }

    @PostMapping("/Plan_Two")
    public String postMethodName2(@ModelAttribute UserandPlan userandplan) {
       UserAndPlanRepo.save(userandplan);
        
        return "success_forPlan";
    }

    @PostMapping("/Plan_Three")
    public String postMethodName3(@ModelAttribute UserandPlan userandplan) {
       UserAndPlanRepo.save(userandplan);
        
        return "success_forPlan";
    }
    @PostMapping("/Plan_Four")
    public String postMethodName4(@ModelAttribute UserandPlan userandplan) {
       UserAndPlanRepo.save(userandplan);
        
        return "success_forPlan";
    }

    @PostMapping("/Plan_Five")
    public String postMethodName5(@ModelAttribute UserandPlan userandplan) {
       UserAndPlanRepo.save(userandplan);
        
        return "success_forPlan";
    }
    @PostMapping("/Plan_Six")
    public String postMethodName6(@ModelAttribute UserandPlan userandplan) {
       UserAndPlanRepo.save(userandplan);
        
        return "success_forPlan";
    }






    
    












    
    
}