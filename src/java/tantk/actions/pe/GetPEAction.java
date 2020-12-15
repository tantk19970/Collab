/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tantk.actions.pe;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import tantk.dao.PracticalExamDAO;
import tantk.dto.PracticalExamDTO;

/**
 *
 * @author Pro
 */
public class GetPEAction extends ActionSupport {

    private Integer subjectId;
    private List<PracticalExamDTO> listPEs;
    private static final String SUCCESS = "succss";
    private static final String FAIL = "fail";

    public GetPEAction() {
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public List<PracticalExamDTO> getListPEs() {
        return listPEs;
    }

    public void setListPEs(List<PracticalExamDTO> listPEs) {
        this.listPEs = listPEs;
    }

    public String execute() throws Exception {
        PracticalExamDAO dao = new PracticalExamDAO();
        dao.getPracticalExamFromSubjectId(subjectId);
        listPEs = dao.getListPEs();
        if (listPEs == null) return FAIL;
        return SUCCESS;
    }

}
