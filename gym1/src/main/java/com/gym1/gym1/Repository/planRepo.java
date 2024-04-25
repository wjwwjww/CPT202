package com.gym1.gym1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym1.gym1.Model.Plan;


@Repository
public interface planRepo extends JpaRepository<Plan, Integer> {
    planRepo findByPlanId(int planId);
}