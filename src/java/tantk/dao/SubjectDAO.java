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
import tantk.dto.SubjectDTO;
import tantk.utils.DBUtils;

/**
 *
 * @author Admin
 */
public class SubjectDAO implements Serializable{

    public SubjectDAO() {
    }

    private List<SubjectDTO> listSubjects;

    public List<SubjectDTO> getListSubjects() {
        return listSubjects;
    }

    public void getSubject(Integer majorId) throws Exception {
        String sql = "SELECT id, subjectName FROM Subject WHERE majorId = ?";
        try (Connection conn = DBUtils.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setInt(1, majorId);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    if (listSubjects == null) {
                        listSubjects = new ArrayList<>();
                    }
                    listSubjects.add(new SubjectDTO(rs.getInt("id"), rs.getString("subjectName")));
                }
            }
        }
    }

    public boolean createSubject(String subjectName, Integer majorId) throws Exception {
        String sql = "INSERT INTO Subject(subjectName) VALUES (?)";
        try (Connection conn = DBUtils.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setInt(1, majorId);
            int rs = stm.executeUpdate();

            if (rs > 0) {
                return true;
            }
            return false;
        }
    }
}
