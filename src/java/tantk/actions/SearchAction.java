/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tantk.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import tantk.dao.RegistrationDAO;
import tantk.dto.RegistrationDTO;

/**
 *
 * @author Admin
 */
public class SearchAction extends ActionSupport {
    private String searchValue;
    private List<RegistrationDTO> list;
    
    public SearchAction() {
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public List<RegistrationDTO> getList() {
        return list;
    }
    
    public String execute() throws Exception {
        RegistrationDAO dao=new RegistrationDAO();
        list=dao.findByLikeName(searchValue);
        return "success";
    }
    
}
