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
import tantk.dto.QuizAnswerDTO;
import tantk.dto.QuizQuestionDTO;
import tantk.utils.DBUtils;

/**
 *
 * @author Pro
 */
public class QuizAnswerDAO implements Serializable{

    public QuizAnswerDAO() {
    }
    
    private List<QuizAnswerDTO> quizAnswers;

    public List<QuizAnswerDTO> getQuizAnswers() {
        return quizAnswers;
    }
    
    public void getQuestionsFromPEId(Integer questionId) throws Exception{
        String sql="SELECT id, answerContent FROM QuizAnswer WHERE questionId = ?";
        try(Connection conn=DBUtils.getConnection();
                PreparedStatement stm=conn.prepareStatement(sql)){
            stm.setInt(1, questionId);
            try(ResultSet rs= stm.executeQuery()){
                quizAnswers = new ArrayList<>();
                while(rs.next()){
//                    if (quizAnswers == null) {
//                        quizAnswers = new ArrayList<>();
//                    }
                    QuizAnswerDTO dto = new QuizAnswerDTO();
                    dto.setAnswerId(rs.getInt("id"));
                    dto.setAnswerContent(rs.getString("answerContent"));
                    quizAnswers.add(dto);
                }
            }
        }
    }
    
}
