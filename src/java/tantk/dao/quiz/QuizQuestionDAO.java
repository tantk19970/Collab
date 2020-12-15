/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tantk.dao.quiz;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import tantk.dto.QuizQuestionDTO;
import tantk.utils.DBUtils;

/**
 *
 * @author Pro
 */
public class QuizQuestionDAO implements Serializable{

    public QuizQuestionDAO() {
    }
    
    private List<QuizQuestionDTO> quizQuestions;

    public List<QuizQuestionDTO> getQuizQuestions() {
        return quizQuestions;
    }
    
    public void getQuestionsFromPEId(Integer peId) throws Exception{
        String sql="SELECT questionContent, score FROM QuizQuestion WHERE peId = ?";
        try(Connection conn=DBUtils.getConnection();
                PreparedStatement stm=conn.prepareStatement(sql)){
            stm.setInt(1, peId);
            try(ResultSet rs= stm.executeQuery()){
                while(rs.next()){
                    if (quizQuestions == null) {
                        quizQuestions = new ArrayList<>();
                    }
                    QuizQuestionDTO dto = new QuizQuestionDTO(null, rs.getString("questionContent"), rs.getInt("score"), null);
                    quizQuestions.add(dto);
                }
            }
        }
    }
    
}
