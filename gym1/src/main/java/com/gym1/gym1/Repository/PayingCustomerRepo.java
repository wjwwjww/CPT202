package com.gym1.gym1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym1.gym1.Model.PayingCustomer;

@Repository
public interface PayingCustomerRepo extends JpaRepository<PayingCustomer, String> {
    PayingCustomer findByEmail(String email);
}
