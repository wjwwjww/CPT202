package com.gym1.gym1.Controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gym1.gym1.Model.Customer;
import com.gym1.gym1.Model.PaymentDetails;
import com.gym1.gym1.Model.PurchasedPlan;
import com.gym1.gym1.Repository.CustomerRepo;
import com.gym1.gym1.Repository.PaymentDetailsRepo;
import com.gym1.gym1.Repository.PurchasedPlanRepo;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes({ "customerEmail", "userType" })
public class CheckoutController {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private PaymentDetailsRepo paymentDetailsRepo;
    @Autowired
    private PurchasedPlanRepo purchasedPlanRepo;

    @GetMapping("/checkout")
    public String checkout(
            @RequestParam(required = false) String plan,
            @RequestParam(required = false) String duration,
            @RequestParam(required = false) String price,
            Model model, HttpSession session) {

        String userType = (String) session.getAttribute("userType");
        String email = (String) session.getAttribute("customerEmail");
        Integer userId = (Integer) session.getAttribute("userId");

        if (email == null || userType == null) {
            return "redirect:/login";
        }
        if (!userType.equals("customer")) {
            model.addAttribute("trainerAlert", "Trainer cannot purchase the Fitness Plan.");
            return "fitnessPlan";
        }

        PurchasedPlan existingPlan = purchasedPlanRepo.findByUserId(userId);
        model.addAttribute("alreadyPurchased", existingPlan != null);
        if (existingPlan != null) {
            model.addAttribute("purchaseAlert",
                    "You have already purchased a plan and cannot purchase another.");
            return "fitnessPlan";
        } else {
            model.addAttribute("showAlert", false); // 플랜이 없을 때는 알림을 표시하지 않음
        }
        Customer customer = customerRepo.findByUserId(userId);
        customer.setUserId(userId);
        model.addAttribute("customer", customer);

        PaymentDetails paymentDetails = new PaymentDetails();
        model.addAttribute("paymentDetails", paymentDetails);

        model.addAttribute("email", email);
        model.addAttribute("plan", plan);
        model.addAttribute("duration", duration);
        model.addAttribute("price", price);

        return "checkout"; // Show checkout page with plan details

    }

    @PostMapping("/processCheckout")
    public String processCheckout(@ModelAttribute Customer formCustomer,
            @ModelAttribute PaymentDetails formPaymentDetails,
            HttpSession session, @RequestParam String plan,
            @RequestParam String duration,
            @RequestParam String price) {

        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return "redirect :/login";
        }
        PurchasedPlan existingPlan = purchasedPlanRepo.findByUserId(userId);
        if (existingPlan != null) {
            return "redirect:/fitnessPlan?error=alreadyPurchased"; // Redirect them with an error query param
        }

        Customer customer = customerRepo.findByUserId(userId);
        if (customer == null) {
            return "redirect:/login";
        }
        customer.setName(formCustomer.getName());
        customer.setPhone(formCustomer.getPhone());
        customer.setGender(formCustomer.getGender());
        customerRepo.save(customer);

        PaymentDetails paymentDetails = paymentDetailsRepo.findByUserId(userId);
        if (paymentDetails == null) {
            paymentDetails = new PaymentDetails();
            paymentDetails.setUserId(userId);
        }

        paymentDetails.setCardholderName(formPaymentDetails.getCardholderName());
        paymentDetails.setCardNumber(formPaymentDetails.getCardNumber());
        paymentDetails.setExpiryMonth(formPaymentDetails.getExpiryMonth());
        paymentDetails.setExpiryYear(formPaymentDetails.getExpiryYear());
        paymentDetails.setCvc(formPaymentDetails.getCvc());
        paymentDetailsRepo.save(paymentDetails);

        PurchasedPlan purchasedPlan = new PurchasedPlan();
        purchasedPlan.setUserId(customer.getUserId());
        purchasedPlan.setPlanName(plan);
        purchasedPlan.setDuration(duration);
        purchasedPlan.setPrice(price);
        purchasedPlan.setPurchaseDate(new Date());
        purchasedPlanRepo.save(purchasedPlan);

        updatePlanStatus(purchasedPlan);

        return "fitnessPlan";
    }

    @GetMapping("/fitnessPlan")
    public String showFitnessPlan(Model model, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/login";
        }
        return "fitnessPlan";
    }

    private void updatePlanStatus(PurchasedPlan purchasedPlan) {
        // Calculate expiry date based on plan duration
        Calendar calendar = Calendar.getInstance();
        String duration = purchasedPlan.getDuration();

        calendar.setTime(purchasedPlan.getPurchaseDate());

        if (duration.equals("6 Months")) {
            calendar.add(Calendar.MONTH, 6);
        } else if (duration.equals("12 Months")) {
            calendar.add(Calendar.MONTH, 12);
        } else {
            System.out.println("Unknown plan duration: " + duration);
        }

        Date expiryDate = calendar.getTime();
        purchasedPlan.setExpiryDate(expiryDate);

        Date currentDate = new Date();
        if (currentDate.after(expiryDate)) {
            purchasedPlan.setStatus("Not Valid");
        } else {
            purchasedPlan.setStatus("Valid");
        }

        purchasedPlanRepo.save(purchasedPlan);
    }
}
