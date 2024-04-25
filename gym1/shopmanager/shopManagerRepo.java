package com.gym1.gym1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym1.gym1.Model.ShopManager;


@Repository
public interface shopManagerRepo extends JpaRepository<ShopManager, Integer> {
    ShopManager findByShopManagerID(int shopManagerID);
}
