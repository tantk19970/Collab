/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tantk.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import tantk.dao.SubjectDAO;
import tantk.dto.SubjectDTO;

/**
 *
 * @author Poca
 */
public class GetAllSubjectAction extends ActionSupport {
        private Integer majorId;
    private static final String SUCCESS = "succss";
    private static final String FAIL = "fail";
    public GetAllSubjectAction() {
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }
    
    public String execute() throws Exception {
        SubjectDAO dao = new SubjectDAO();
        dao.getListSubjects();
        List<SubjectDTO> rs = dao.getListSubjects();
        if (rs == null || rs.size() <= 0) return FAIL;
        return SUCCESS;
    }
    
}
