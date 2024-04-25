package com.gym1.gym1.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
public class ShopManager {
    @Id
    private int shopManagerID;
    private String shopManagerPassword;
    private String shopManagerName;
    private String shopManagerEmail;

    public ShopManager(int shopManagerID, String shopManagerPassword, String shopManagerName, String shopManagerEmail) {
        this.shopManagerID = shopManagerID;
        this.shopManagerPassword = shopManagerPassword;
        this.shopManagerName = shopManagerName;
        this.shopManagerEmail = shopManagerEmail;
    }
    
    public ShopManager() {
    }

    public int getShopManagerID() {
        return shopManagerID;
    }

    public void setShopManagerID(int shopManagerID) {
        this.shopManagerID = shopManagerID;
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

    public String getShopNanagerEmail() {
        return shopManagerEmail;
    }

    public void setShopManagerEmail(String shopManagerEmail) {
        this.shopManagerEmail = shopManagerEmail;
    }


}