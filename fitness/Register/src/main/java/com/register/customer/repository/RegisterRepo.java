package com.register.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.register.customer.model.Register;

@Repository
public interface RegisterRepo extends JpaRepository<Register, String> {
    Register findByEmail(String email);
}