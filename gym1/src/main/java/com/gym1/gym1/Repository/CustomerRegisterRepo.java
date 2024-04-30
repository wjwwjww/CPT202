package com.gym1.gym1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym1.gym1.Model.CustomerRegister;

@Repository
public interface CustomerRegisterRepo extends JpaRepository<CustomerRegister, String> {
    CustomerRegister findByEmail(String email);
}
