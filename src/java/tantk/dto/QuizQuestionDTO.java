/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tantk.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Pro
 */
public class QuizQuestionDTO implements Serializable {
    private Integer questionId;
    private String questionContent;
    private Integer score;
    private List<QuizAnswerDTO> answers;

    public QuizQuestionDTO() {
    }

    public QuizQuestionDTO(Integer id, String questionContent, Integer score, List<QuizAnswerDTO> answers) {
        this.questionId = id;
        this.questionContent = questionContent;
        this.score = score;
        this.answers = answers;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<QuizAnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<QuizAnswerDTO> answers) {
        this.answers = answers;
    }
    
    
}
