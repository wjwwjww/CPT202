package com.gym1.gym1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym1.gym1.Model.PurchasedPlan;

@Repository
public interface PurchasedPlanRepo extends JpaRepository<PurchasedPlan, String> {
    PurchasedPlan findByEmail(String email);

}
