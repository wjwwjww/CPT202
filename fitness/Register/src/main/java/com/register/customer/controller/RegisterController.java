package com.register.customer.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.register.customer.model.Register;
import com.register.customer.repository.RegisterRepo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {
    @Autowired
    private RegisterRepo registerRepo; // RegisterRepo인스턴스를 자동으로

    private static final String TERMS_AGREED = "termsAgreed";
    private static final String REGISTERED = "registered";
    private static final String EMAIL_VALIDATION_STATUS = "emailValidationStatus";

    @GetMapping("/agreement")
    public String getTerms() {
        return "agreement";
    }

    @PostMapping("/submit_agreement")
    public String postRegister(HttpServletRequest request, RedirectAttributes redirectAttributes) {

        boolean termsAgreed = request.getParameter("term1") != null && request.getParameter("term2") != null;
        if (termsAgreed) {
            request.getSession().setAttribute("termsAgreed", termsAgreed);
            return "redirect:/accountCreation"; // 이메일 입력 페이지로 리디렉션
        } else {
            // Here you can add attributes to the redirect to show a message that terms must
            // be agreed.
            return "redirect:/agreement";
        }
    }

    @GetMapping("/accountCreation") /* 무조건 1단계 약관동의를 완료해야 등록페이지 나옴 */
    public String getRegister(Model model, HttpSession session) {
        Boolean termsAgreed = (Boolean) session.getAttribute("termsAgreed");
        if (Boolean.TRUE.equals(termsAgreed)) {
            return "accountCreation";
        } else {
            // Redirect to the agreement page if terms are not agreed
            return "redirect:/agreement";
        }
    }

    @PostMapping("/accountCreation")
    public String postRegister(@ModelAttribute Register register, HttpSession session,
            RedirectAttributes redirectAttributes) {

        // Check for agreement to terms
        if (session.getAttribute(TERMS_AGREED) != Boolean.TRUE) {
            return "redirect:/agreement";
        }
        // Check email validation status
        if ("available".equals(session.getAttribute(EMAIL_VALIDATION_STATUS))) {
            registerRepo.save(register);
            session.setAttribute(REGISTERED, true);

            return "redirect:/completion";
        } else {
            return "redirect:/accountCreation";
        }
    }

    @PostMapping("/verify-email")
    @ResponseBody
    public ResponseEntity<?> verifyEmail(@RequestBody Map<String, String> request, HttpSession session) {
        String email = request.get("email");
        Map<String, String> response = new HashMap<>();

        // 정규 표현식을 사용하여 이메일 형식 검증
        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            // 유효한 이메일 형식이 아닌 경우
            response.put("status", "invalid");
        } else if (registerRepo.existsById(email)) {
            // 이메일이 이미 사용 중인 경우
            response.put("status", "used");
            session.setAttribute("emailValidationStatus", "used");
        } else {
            // 이메일이 사용 가능한 경우
            response.put("status", "available");
            session.setAttribute("emailValidationStatus", "available");
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/completion")
    public String getCompletion(HttpSession session) {
        Boolean termsAgreed = (Boolean) session.getAttribute("termsAgreed");
        Boolean registered = (Boolean) session.getAttribute("registered");

        // 약관 동의와 등록이 모두 완료된 경우에만 완료 페이지 표시
        if (Boolean.TRUE.equals(termsAgreed) && Boolean.TRUE.equals(registered)) {
            session.invalidate();
            return "completion";
        } else {
            // 필수 단계를 거치지 않은 경우 리디렉션
            if (!Boolean.TRUE.equals(termsAgreed)) {
                return "redirect:/agreement";
            } else {
                return "redirect:/register";
            }
        }
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/fitnessplan")
    public String getfitnessplan() {
        return "fitnessPlan";
    }

}