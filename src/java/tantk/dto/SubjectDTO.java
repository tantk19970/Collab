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
public class SubjectDTO implements Serializable{
    private String subID,subName,mayorID,mayorName;
//    "Select \n" +
//"From tbl_Subject s,tbl_Major m where s.MajorID=m.MajorID"

    public SubjectDTO() {
    }

    public SubjectDTO(String subID, String subName, String mayorID) {
        this.subID = subID;
        this.subName = subName;
        this.mayorID = mayorID;
    }

    public String getSubID() {
        return subID;
    }

    public void setSubID(String subID) {
        this.subID = subID;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getMayorID() {
        return mayorID;
    }

    public void setMayorID(String mayorID) {
        this.mayorID = mayorID;
    }

    public String getMayorName() {
        return mayorName;
    }

    public void setMayorName(String mayorName) {
        this.mayorName = mayorName;
    }
    
    
    
}
