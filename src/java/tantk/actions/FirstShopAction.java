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
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
import tantk.dao.CategoryDAO;
import tantk.dao.ProductDAO;
import tantk.dto.LessionDTO;
import tantk.dto.ProductDTO;
import tantk.dto.SubjectDTO;

/**
 *
 * @author Admin
 */
public class FirstShopAction extends ActionSupport {
    private String shopType;
    private List<ProductDTO> listCate;

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    public List<ProductDTO> getListCate() {
        return listCate;
    }

    public void setListCate(List<ProductDTO> listCate) {
        this.listCate = listCate;
    }
    
    
    
    
    public FirstShopAction() {
    }
    
    public String execute() throws Exception {
//        ServletContext context= ServletActionContext.getServletContext();
        CategoryDAO dao= new CategoryDAO();
        Map session=ActionContext.getContext().getSession();
        if(shopType.equals("shopSub")){
            listCate= dao.getAllSubject();
            session.put("SHOP", "Subject");
        }else if(shopType.equals("shopLes")){
            listCate=dao.getAllLession();
            session.put("SHOP", "Lession");
        }
        return "success1";
    }
    
}
