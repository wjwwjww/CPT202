package com.gym1.gym1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym1.gym1.Model.Shopmanager;



public interface shopManagerrepo extends JpaRepository<Shopmanager, String> {
    Shopmanager findByShopManagerId(String shopManagerId);
    boolean existsByShopManagerId(String shopManagerId);

}
