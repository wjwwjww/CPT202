package com.gym1.gym1.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.gym1.gym1.Model.Plan;
import com.gym1.gym1.Model.UserandPlan;
import com.gym1.gym1.Repository.planRepo;
import com.gym1.gym1.Repository.userAndplanRepo;
import com.gym1.gym1.Repository.userRepo;





@Controller
public class purchasePlanController {

@Autowired
private planRepo PlanRepo;
@Autowired
private userRepo UserRepo;
@Autowired
private userAndplanRepo UserAndPlanRepo;

    @GetMapping("/Plan")
    public String purchasePlan(Model model) {
        model.addAttribute("UserandPlan", new UserandPlan());
        return "Plan";
    }


    @PostMapping("/Plan")
    public String postMethodName(@ModelAttribute UserandPlan userandplan) {
       UserAndPlanRepo.save(userandplan);
        
        return "success_forPlan";
    }
    



    @GetMapping("/api/Plans")
    public List<Plan> getPlan(){
        List<Plan> plans = new ArrayList<>();

        Plan plan = new Plan(1,  "Silver Plan for 6 Months", 6, 3);
        plans.add(plan);
        Plan plan1 = new Plan(2,  "Silver Plan for 12 Months", 12, 3);
        plans.add(plan1);
        return plans;
       
    }
    
    @PostMapping("/api/Plan")
    public void postPlan(@RequestBody List<Plan> plans) {
        // Save each plan in the list
        for (Plan plan : plans) {
            PlanRepo.save(plan);
        }
    }
    

}
    
