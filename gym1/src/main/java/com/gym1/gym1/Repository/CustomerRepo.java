package com.gym1.gym1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym1.gym1.Model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    Customer findByUserId(Integer userId);

    Customer findByEmail(String email);

}
