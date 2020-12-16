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
import tantk.dto.PracticalExamDTO;
import tantk.utils.DBUtils;

/**
 *
 * @author Pro
 */
public class PracticalExamDAO implements Serializable {

    public PracticalExamDAO() {
    }

    private List<PracticalExamDTO> listPEs;

    public List<PracticalExamDTO> getListPEs() {
        return listPEs;
    }

    public void getPracticalExamFromSubjectId(Integer subjectId) throws Exception {
        String sql = "Select peName, duration, peType From pe Where subjectId = ?";
        try (Connection conn = DBUtils.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setInt(1, subjectId);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    if (listPEs == null) {
                        listPEs = new ArrayList<>();
                    }
                    String peName = rs.getString("peName");
                    String peType = rs.getString("peType");
                    Integer duration = rs.getInt("duration");

                    PracticalExamDTO dto = new PracticalExamDTO(peName, peType, subjectId, duration);
                    listPEs.add(dto);
                }
            }
        }
    }

    public PracticalExamDTO getPracticalExamDetail(Integer peId) throws Exception {
        String sql = "Select peName, duration, peType, subjectId From pe Where id = ?";
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);

            stm.setInt(1, peId);
            rs = stm.executeQuery();
            while (rs.next()) {
                if (listPEs == null) {
                    listPEs = new ArrayList<>();
                }
                String peName = rs.getString("peName");
                String peType = rs.getString("peType");
                Integer duration = rs.getInt("duration");
                Integer subjectId = rs.getInt("subjectId");

                PracticalExamDTO dto = new PracticalExamDTO(peName, peType, subjectId, duration);
                return dto;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }

}
