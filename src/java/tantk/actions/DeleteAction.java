/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tantk.actions;

import com.opensymphony.xwork2.ActionSupport;
import tantk.dao.CategoryDAO;
import tantk.dao.ProductDAO;

/**
 *
 * @author Admin
 */
public class DeleteAction extends ActionSupport {
    private String productID,lastSub,lastSearchValue;

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }
    

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getLastSub() {
        return lastSub;
    }

    public void setLastSub(String lastSub) {
        this.lastSub = lastSub;
    }
    
    
    public DeleteAction() {
    }
    
    public String execute() throws Exception {
        ProductDAO dao=new ProductDAO();
        
        if(dao.DeleteLessionByProID(productID)) return "success";
        else if(lastSub.equals("admin")) {
            dao.DeleteAccountByID(productID);
            return "admin";
        }
        return "error";
    }
    
}
