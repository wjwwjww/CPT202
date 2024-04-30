package com.gym1.gym1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym1.gym1.Model.PaymentDetails;

@Repository
public interface PaymentDetailsRepo extends JpaRepository<PaymentDetails, String> {
    PaymentDetails findByEmail(String email);

}
