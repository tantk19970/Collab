/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tantk.dto;

/**
 *
 * @author Admin
 */
public class LessionDTO {
    private String leID,leName,shopType;

    public LessionDTO() {
    }

    public LessionDTO(String leID, String leName, String shopType) {
        this.leID = leID;
        this.leName = leName;
        this.shopType = shopType;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    

    public String getLeID() {
        return leID;
    }

    public void setLeID(String leID) {
        this.leID = leID;
    }

    public String getLeName() {
        return leName;
    }

    public void setLeName(String leName) {
        this.leName = leName;
    }
    
    
    
}
