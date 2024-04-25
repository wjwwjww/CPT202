package com.gym1.gym1.Controller;

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

import com.gym1.gym1.Model.ShopManager;
import com.gym1.gym1.Repository.shopManagerRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class shopManagerController {
    @Autowired
    private shopManagerRepo shopManagerRepo;
    @Autowired
    private HttpSession session;
    

    @GetMapping("/ShopManagers_page")
    public String getShopManagerPage(Model m) {
    List<ShopManager> ShopManagers = shopManagerRepo.findAll();
    m.addAttribute("ShopManagers", ShopManagers);
    return "main_forShopManager";
    }

    @GetMapping("/add_ShopManager")
    public String getAddShopManager(Model model){
        model.addAttribute("ShopManager", new ShopManager());
        return "addShopManager";
    }

    @PostMapping("/add_ShopManager")
    public String postAddShopManager(@ModelAttribute ShopManager ShopManager){
        shopManagerRepo.save(ShopManager);

       
        return "success_forShopManager";
    }

    @PostMapping("/shopManagerLogin")
    public ModelAndView shopManagerLogin(@RequestParam int shopManagerID, @RequestParam String shopManagerPassword) {
        ShopManager shopmanager = shopManagerRepo.findByShopManagerID(shopManagerID);

        if (shopmanager != null && shopmanager.getShopManagerPassword().equals(shopManagerPassword)) {
            // Trainer login successful
            // Redirect or return some response
            session.setAttribute("loggedInShopManager", shopmanager);
            return new ModelAndView("redirect:/shopManagerPage");
        } else {
            // Trainer login failed
            // Redirect back to login page with error message
            ModelAndView modelAndView = new ModelAndView("main_page");
            modelAndView.addObject("shopManagerLoginError", "Invalid ID or password");
            return modelAndView;
        }
    }

    @GetMapping("/shopManagerPage")
    public String AfterShopManagerLogin() {
        return "shopManagerPage";
    }

    @GetMapping("/getShopManagerData")
    @ResponseBody
    public Map<String, String> getShopManagerData() {
    Map<String, String> response = new HashMap<>();
    ShopManager shopmanager = (ShopManager) session.getAttribute("loggedInShopManager");
    if (shopmanager != null) {
        response.put("shopManagerName", shopmanager.getShopManagerName());
    } else {
        response.put("error", "Shop Manager not logged in");
    }
    return response;
    }

}