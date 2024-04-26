package com.gym1.gym1.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Shopmanager {
    @Id
    private String shopManagerId;
    private String shopManagerPassword;
    private String shopManagerName;


    
    public Shopmanager(String shopManagerId, String shopManagerPassword, String shopManagerName) {
        this.shopManagerId = shopManagerId;
        this.shopManagerPassword = shopManagerPassword;
        this.shopManagerName = shopManagerName;
    }
    public Shopmanager() {
    }
    public String getShopManagerId() {
        return shopManagerId;
    }
    public void setShopManagerId(String shopManagerId) {
        this.shopManagerId = shopManagerId;
    }
    public String getShopManagerPassword() {
        return shopManagerPassword;
    }
    public void setShopManagerPassword(String shopManagerPassword) {
        this.shopManagerPassword = shopManagerPassword;
    }
    public String getShopManagerName() {
        return shopManagerName;
    }
    public void setShopManagerName(String shopManagerName) {
        this.shopManagerName = shopManagerName;
    }
    
    
}
