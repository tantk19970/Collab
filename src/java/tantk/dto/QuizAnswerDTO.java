/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tantk.dto;

import java.io.Serializable;

/**
 *
 * @author Pro
 */
public class QuizAnswerDTO implements Serializable {

    private Integer answerId;
    private String answerContent;
    private Boolean correct;
    private Boolean studentChecked;

    public QuizAnswerDTO() {
    }

    public QuizAnswerDTO(Integer answerId, String answerContent, Boolean correct, Boolean studentChecked) {
        this.answerId = answerId;
        this.answerContent = answerContent;
        this.correct = correct;
        this.studentChecked = studentChecked;
    }

    public QuizAnswerDTO(Integer id, String answerContent, Boolean correct) {
        this.answerId = id;
        this.answerContent = answerContent;
        this.correct = correct;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public Boolean getStudentChecked() {
        return studentChecked;
    }

    public void setStudentChecked(Boolean studentChecked) {
        this.studentChecked = studentChecked;
    }

}
