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
import tantk.dto.ProductDTO;

/**
 *
 * @author Admin
 */
public class CategoryDAO implements Serializable{
    private static final String connString="jdbc:sqlserver://localhost:1433;databaseName=FAPManagement";
    private static final String user="sa";
    private static final String pass="1234";
    private static final String forName="com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public CategoryDAO() {
    }
    
    
    public List<ProductDTO> getAllSubject() throws Exception{
        Class.forName(forName);
        List<ProductDTO> list=null;
        String subID,subName,shopType;
        ProductDTO dto;
        String sql="Select SubID,SubName from tbl_Subject";
        try(Connection conn=DriverManager.getConnection(connString, user, pass);
                PreparedStatement stm=conn.prepareStatement(sql)){
            try (ResultSet rs = stm.executeQuery()) {
                list = new ArrayList<>();
                while (rs.next()) {
                    subID = rs.getString("SubID");
                    subName = rs.getString("SubName");
                    shopType="Subject";
                    dto = new ProductDTO(subID, subName,shopType);
                    list.add(dto);
                }
            }
            
        }
        return list;
    }
    
    public List<ProductDTO> getAllLession() throws Exception{
        Class.forName(forName);
        List<ProductDTO> list=null;
        String leID,leName,shopType;
        ProductDTO dto;
        String sql="Select LeID,LeName from tbl_Lession";
        try(Connection conn=DriverManager.getConnection(connString, user, pass);
                PreparedStatement stm=conn.prepareStatement(sql)){
            try (ResultSet rs = stm.executeQuery()) {
                list = new ArrayList<>();
                while (rs.next()) {
                    leID = rs.getString("LeID");
                    leName = rs.getString("LeName");
                    shopType = "Lession";
                    dto = new ProductDTO(leID, leName, shopType);
                    list.add(dto);
                }
            }
            
            
        }
        return list;
    }
    
    public List<ProductDTO> getLessionBySubID(String subID) throws Exception{
        Class.forName(forName);
        List<ProductDTO> list=null;
        String leID,leName,theory,excer;
        ProductDTO dto;
        String sql="Select LeID,LeName,Theory,Excercise from tbl_Lession where SubID=?";
        try(Connection conn=DriverManager.getConnection(connString, user, pass);
                PreparedStatement stm=conn.prepareStatement(sql)){
            stm.setString(1, subID);
            try(ResultSet rs=stm.executeQuery()){
                list= new ArrayList<>();
                while(rs.next()){
                    leID=rs.getString("LeID");
                    leName=rs.getString("LeName");
                    theory=rs.getString("Theory");
                    excer=rs.getString("Excercise");
                    dto=new ProductDTO(leID, leName, theory, excer);
                    list.add(dto);
                }
            }
        }
        return list;
    }
    
}
