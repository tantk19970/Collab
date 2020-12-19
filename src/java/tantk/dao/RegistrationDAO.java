/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tantk.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import tantk.dto.RegistrationDTO;

/**
 *
 * @author Admin
 */
public class RegistrationDAO implements Serializable{
    private final static String connString ="jdbc:sqlserver://localhost:1433;databaseName=FAPManagement";
    private final static String user="sa";
    private final static String pass="1234";
    private final static String forName="com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public RegistrationDAO() {
    }
    
    public String checkLogin(String username,String password) throws Exception{
        Class.forName(forName);
        String role="fail";
        String sql="Select Role From tbl_Registration Where Username=? and Password=?";
        try(Connection conn=DriverManager.getConnection(connString, user,pass );
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
        Class.forName(forName);
        String username,fullname,role,major,year;
        List<RegistrationDTO> result=null;
        RegistrationDTO dto;
        String sql="Select Username,Fullname,Role,MajorID,Year From tbl_Registration "
                + "Where Username LIKE ?";
        try(Connection conn=DriverManager.getConnection(connString, user, pass);
                PreparedStatement stm=conn.prepareStatement(sql)){
            stm.setString(1, "%"+search+"%");
            try(ResultSet rs=stm.executeQuery()){
                result= new ArrayList<>();
                while(rs.next()){
                    username=rs.getString("Username");
                    fullname=rs.getString("Fullname");
                    role=rs.getString("Role");
                    major=rs.getString("MajorID");
                    year=rs.getString("Year");
                    dto= new RegistrationDTO(username, fullname, role, major, year);
                    result.add(dto);
                }
            }
        }
        return result;
    }
    
}
