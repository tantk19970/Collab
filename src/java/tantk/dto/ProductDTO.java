/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tantk.dto;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class ProductDTO implements Serializable{
    private String proID,proName,shopType,theory,excer;

    public ProductDTO() {
    }

    public ProductDTO(String proID, String proName) {
        this.proID = proID;
        this.proName = proName;
    }

    public ProductDTO(String proID, String proName, String theory, String excer) {
        this.proID = proID;
        this.proName = proName;
        this.theory = theory;
        this.excer = excer;
    }
    
    

    public ProductDTO(String proID, String proName, String shopType) {
        this.proID = proID;
        this.proName = proName;
        this.shopType = shopType;
    }

    public String getTheory() {
        return theory;
    }

    public void setTheory(String theory) {
        this.theory = theory;
    }

    public String getExcer() {
        return excer;
    }

    public void setExcer(String excer) {
        this.excer = excer;
    }
    

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }
    
    
    
    
    
}
