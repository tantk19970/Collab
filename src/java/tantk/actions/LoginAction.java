/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tantk.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import java.util.Map;
import javax.servlet.ServletContext;
import tantk.dao.RegistrationDAO;

/**
 *
 * @author Admin
 */
public class LoginAction extends ActionSupport {
    private String username,password;
    private final static String ERROR="error";
    private final static String ADMIN="admin";
    private final static String USER="user";

    public String getUsername() {
        return username;
    }
    @RequiredStringValidator(type = ValidatorType.FIELD,
            message = "Username can't be blank!!!")

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    
    @RequiredStringValidator(type = ValidatorType.FIELD,
            message = "Password can't be black!!!")
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    public LoginAction() {
    }
    
    public String execute() throws Exception {
        String url = ERROR;
        RegistrationDAO dao = new RegistrationDAO();
        String role = dao.checkLogin(username, password);
        Map session = ActionContext.getContext().getSession();
        if (role.equals("fail")) {
            session.put("ERROR", "Username or password incorrect");
        } else {
            session.put("USER",username);
            if (role.equals("admin")) {
                url = ADMIN;
            } else if (role.equals("user")) {
                url = USER;
            } else {
                session.put("ERROR", "Invalid Role");
            }
        }
        return url;
    }
    
}
