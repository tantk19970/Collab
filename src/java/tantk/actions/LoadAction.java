/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tantk.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import tantk.dao.CategoryDAO;
import tantk.dto.ProductDTO;

/**
 *
 * @author Admin
 */
public class LoadAction extends ActionSupport {
    private String txtProID,shopType;
    private List<ProductDTO> listLoad;

    public List<ProductDTO> getListLoad() {
        return listLoad;
    }

    
    public void setListLoad(List<ProductDTO> listLoad) {
        this.listLoad = listLoad;
    }
    

    public String getTxtProID() {
        return txtProID;
    }

    public void setTxtProID(String txtProID) {
        this.txtProID = txtProID;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }
    
    
    public LoadAction() {
    }
    
    public String execute() throws Exception {
        CategoryDAO dao=new CategoryDAO();
        Map session=ActionContext.getContext().getSession();
        if(shopType.equals("Subject")){
            listLoad=dao.getLessionBySubID(txtProID);
            session.put("LASTSUB", txtProID);
        }
        return "success";
    }
    
}
