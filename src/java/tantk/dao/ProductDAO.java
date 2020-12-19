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
import tantk.dto.SubjectDTO;

/**
 *
 * @author Admin
 */
public class ProductDAO implements Serializable {

    private static final String connString = "jdbc:sqlserver://localhost:1433;databaseName=FAPManagement";
    private static final String user = "sa";
    private static final String pass = "1234";
    private static final String forName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public ProductDAO() {
    }

    public List<SubjectDTO> getAllSubjectByMajorID(String majorID) throws Exception {
        Class.forName(forName);
        List<SubjectDTO> list = null;
        SubjectDTO dto;
        String subID, subName, sql = "Select subID,subName from tbl_Subject where MajorID=?";
        try(Connection conn=DriverManager.getConnection(connString, user, pass);
                PreparedStatement stm=conn.prepareStatement(sql)){
            stm.setString(1, majorID);
            try(ResultSet rs=stm.executeQuery()){
                list=new ArrayList<>();
                while(rs.next()){
                    subID=rs.getString("SubID");
                    subName=rs.getString("SubName");
                    dto= new SubjectDTO(subID, subName);
                    list.add(dto);
                }
            }
        }

        return list;
    }
    
    public boolean DeleteLessionByProID(String proID)throws Exception{
        Class.forName(forName);
        boolean check=false;
        String sql="Delete from tbl_Lession where LeID=?";
        try(Connection conn=DriverManager.getConnection(connString, user, pass);
                PreparedStatement stm=conn.prepareStatement(sql)){
            stm.setString(1, proID);
            check=stm.executeUpdate()>0;
        }
        return check;
    }
    
    public void DeleteAccountByID(String username)throws Exception{
        Class.forName(forName);
        String sql="Delete from tbl_Registration where Username=?";
        try(Connection conn=DriverManager.getConnection(connString, user, pass);
                PreparedStatement stm=conn.prepareStatement(sql)){
            stm.setString(1, username);
            stm.executeUpdate();
        }
    }
}
