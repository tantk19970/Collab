/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tantk.actions.subject;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import tantk.dao.SubjectDAO;

/**
 *
 * @author Poca
 */
public class CreateSubjectAction extends ActionSupport {
    private String subjectName;
    private Integer majorId;
    private static final String SUCCESS = "succss";
    private static final String FAIL = "fail";
    public CreateSubjectAction() {
    }

    public String getSubjectName() {
        return subjectName;
    }

    @RequiredStringValidator(type = ValidatorType.FIELD,
            message = "Subject Name can't be blank!!!")
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getMajorId() {
        return majorId;
    }

    @RequiredStringValidator(type = ValidatorType.FIELD,
            message = "MajorId must be larger than 0!")
    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }
    
    public String execute() throws Exception {
        SubjectDAO dao = new SubjectDAO();
        if (subjectName == null || subjectName.trim().length() <= 0 || majorId < 0) {
            return FAIL;
        }
        boolean rs = dao.createSubject(subjectName, majorId);
        if (!rs) return FAIL;
        return SUCCESS;
    }
    
}
