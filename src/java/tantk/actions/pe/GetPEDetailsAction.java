/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tantk.actions.pe;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
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
    private PracticalExamDTO peDetail;
    private String jsonResult;
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    public GetPEDetailsAction() {
    }

    public Integer getPeId() {
        return peId;
    }

    public void setPeId(Integer peId) {
        this.peId = peId;
    }

    public PracticalExamDTO getPeDetail() {
        return peDetail;
    }

    public void setPeDetail(PracticalExamDTO peDetail) {
        this.peDetail = peDetail;
    }

    public String getJsonResult() {
        return jsonResult;
    }

    public void setJsonResult(String jsonResult) {
        this.jsonResult = jsonResult;
    }

    

    public String execute() throws Exception {
        PracticalExamDAO peDAO = new PracticalExamDAO();
        //get PE Detail
//        PracticalExamDTO dto = peDAO.getPracticalExamDetail(peId);
        peId = 8;
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
        Map session = ActionContext.getContext().getSession();
        Gson gson = new Gson();
        jsonResult = gson.toJson(dto);
        session.put("PEDETAILJSON", jsonResult);
        session.put("PEDETAIL", dto);
        return SUCCESS;
    }

}
