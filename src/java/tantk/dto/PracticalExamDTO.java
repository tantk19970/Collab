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
public class PracticalExamDTO implements Serializable{
    private Integer peId;
    private String peName;
    private String peType;
    private Integer subjectId;
    private Integer duration;
    private List<QuizQuestionDTO> questions;

    public PracticalExamDTO() {
    }

    public PracticalExamDTO(Integer peId, String peName, String peType, Integer subjectId, Integer duration, List<QuizQuestionDTO> questions) {
        this.peId = peId;
        this.peName = peName;
        this.peType = peType;
        this.subjectId = subjectId;
        this.duration = duration;
        this.questions = questions;
    }

    //create new PE
    public PracticalExamDTO(String peName, String peType, Integer subjectId) {
        this.peName = peName;
        this.peType = peType;
        this.subjectId = subjectId;
    }
    
    //construct list of PE (do not get answer)
    public PracticalExamDTO(Integer peId, String peName, String peType, Integer subjectId, Integer duration) {
        this.peId = peId;
        this.peName = peName;
        this.peType = peType;
        this.subjectId = subjectId;
        this.duration = duration;
    }
    

    public Integer getPeId() {
        return peId;
    }

    public void setPeId(Integer peId) {
        this.peId = peId;
    }

    public String getPeName() {
        return peName;
    }

    public void setPeName(String peName) {
        this.peName = peName;
    }

    public String getPeType() {
        return peType;
    }

    public void setPeType(String peType) {
        this.peType = peType;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public List<QuizQuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuizQuestionDTO> questions) {
        this.questions = questions;
    }
    
    
}
