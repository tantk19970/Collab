/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tantk.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import tantk.dto.RegistrationDTO;
import tantk.utils.DBUtils;

/**
 *
 * @author Admin
 */
public class RegistrationDAO implements Serializable{

    public RegistrationDAO() {
    }
    
    public String checkLogin(String username,String password) throws Exception{
        String role="fail";
        String sql="Select Role From Accounts Where Username=? and Password=?";
        try(Connection conn=DBUtils.getConnection();
                PreparedStatement stm=conn.prepareStatement(sql)){
            stm.setString(1, username);
            stm.setString(2, password);
            try(ResultSet rs= stm.executeQuery()){
                if(rs.next()){
                    role=rs.getString("Role");
                }
            }
        }
        return role;
    }
    
    public List<RegistrationDTO> findByLikeName(String search)throws Exception{
        String username,fullname,role,major;
        List<RegistrationDTO> result=null;
        RegistrationDTO dto;
        String sql="Select Username, role From Accounts "
                + "Where Username LIKE ?";
        try(Connection conn=DBUtils.getConnection();
                PreparedStatement stm=conn.prepareStatement(sql)){
            stm.setString(1, "%"+search+"%");
            try(ResultSet rs=stm.executeQuery()){
                result= new ArrayList<>();
                while(rs.next()){
                    username=rs.getString("Username");
                    fullname=rs.getString("Fullname");
                    role=rs.getString("Role");
                    major=rs.getString("MajorID");
                    dto= new RegistrationDTO(username, fullname, role, major);
                    result.add(dto);
                }
            }
        }
        return result;
    }
    
}
