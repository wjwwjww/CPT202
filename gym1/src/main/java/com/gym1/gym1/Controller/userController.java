package com.gym1.gym1.Controller;

import com.gym1.gym1.Model.User;
import com.gym1.gym1.Repository.userRepo;

import jakarta.servlet.http.HttpSession;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class userController {

    @Autowired
    private userRepo userrepo;

    @Autowired
    private HttpSession session;

   
   
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
    public String getUserData() {
        // Get userEmail from session
        String userEmail = ((User) session.getAttribute("loggedInUser")).getuserEmail();
       
        return userEmail;
    }


    
    
}
