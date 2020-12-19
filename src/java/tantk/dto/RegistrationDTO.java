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
public class RegistrationDTO implements Serializable{
    private String username,fullname,role,major,year;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String username, String fullname, String role, String major, String year) {
        this.username = username;
        this.fullname = fullname;
        this.role = role;
        this.major = major;
        this.year = year;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    
}
