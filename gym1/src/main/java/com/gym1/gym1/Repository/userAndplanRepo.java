package com.gym1.gym1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym1.gym1.Model.UserandPlan;


@Repository
public interface userAndplanRepo extends JpaRepository<UserandPlan, Integer> {
    UserandPlan findByPurchaseId(int purchaseId);
}
