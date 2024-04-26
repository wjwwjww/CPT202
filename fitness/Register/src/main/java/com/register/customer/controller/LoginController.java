package com.register.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.register.customer.model.Register;
import com.register.customer.repository.RegisterRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private RegisterRepo registerRepo;

    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password,
            Model model,
            HttpSession session) {

        Register register = registerRepo.findByEmail(email);

        if (register != null && register.getPassword().equals(password)) {
            // 성공적으로 로그인 처리
            session.setAttribute("memberEmail", register.getEmail());
            return "redirect:/fitnessplan"; // 성공시 리다이렉트
        } else {
            // 실패시 에러 메시지와 함께 로그인 페이지로 다시 리다이렉트
            model.addAttribute("loginError", "Invalid email or password.");
            return "login"; // 로그인 뷰 페이지로 리다이렉트
        }
    }
}