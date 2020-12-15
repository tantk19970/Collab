/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tantk.actions.pe;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import tantk.dao.PracticalExamDAO;
import tantk.dao.quiz.QuizAnswerDAO;
import tantk.dao.quiz.QuizQuestionDAO;
import tantk.dto.PracticalExamDTO;
import tantk.dto.QuizQuestionDTO;

/**
 *
 * @author Pro
 */
public class GetPEDetailsAction extends ActionSupport {

    private Integer peId;
    private List<PracticalExamDTO> listPEs;
    private static final String SUCCESS = "succss";
    private static final String FAIL = "fail";

    public GetPEDetailsAction() {
    }

    public Integer getPeId() {
        return peId;
    }

    public void setPeId(Integer peId) {
        this.peId = peId;
    }

    public List<PracticalExamDTO> getListPEs() {
        return listPEs;
    }

    public void setListPEs(List<PracticalExamDTO> listPEs) {
        this.listPEs = listPEs;
    }

    public String execute() throws Exception {
        PracticalExamDAO peDAO = new PracticalExamDAO();
        //get PE Detail
        PracticalExamDTO dto = peDAO.getPracticalExamDetail(peId);
        if (dto == null) {
            return FAIL;
        }
        QuizQuestionDAO questionDAO = new QuizQuestionDAO();
        questionDAO.getQuestionsFromPEId(peId);
        //get Questions available in PE
        List<QuizQuestionDTO> questions = questionDAO.getQuizQuestions();
        if (questions == null) {
            return FAIL;
        }
        
        //get answers for each questions
        QuizAnswerDAO answerDAO = new QuizAnswerDAO();
        for (QuizQuestionDTO aQuestion : questions) {
            answerDAO.getQuestionsFromPEId(aQuestion.getQuestionId());
            aQuestion.setAnswers(answerDAO.getQuizAnswers());
        }
        dto.setQuestions(questions);
        return SUCCESS;
    }

}
