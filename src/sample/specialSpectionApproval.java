package sample;

/*
 * 该类主要负责特检特治的描述
 * @author: 杨越
 * @version: v1
 * */


import java.io.Serializable;

public class specialSpectionApproval implements Serializable{
    private static final long serialVersionUID = 8504896965939479380L;
    private String approvalId;
    private String personId;
    private time beginTime;
    private time endTime;
    private String prescriptionId;
    private String approvalPerson;
    private String approvalSuggestion;
    private String approvalTime;

    /*
    * 构造器
    * */

    public specialSpectionApproval(String approvalId, String personId, time beginTime,
                                   time endTime, String prescriptionId, String approvalPerson,
                                   String approvalSuggestion, String approvalTime) {
        this.approvalId = approvalId;
        this.personId = personId;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.prescriptionId = prescriptionId;
        this.approvalPerson = approvalPerson;
        this.approvalSuggestion = approvalSuggestion;
        this.approvalTime = approvalTime;
    }

    public String getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(String approvalId) {
        this.approvalId = approvalId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public time getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(time beginTime) {
        this.beginTime = beginTime;
    }

    public time getEndTime() {
        return endTime;
    }

    public void setEndTime(time endTime) {
        this.endTime = endTime;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getApprovalPerson() {
        return approvalPerson;
    }

    public void setApprovalPerson(String approvalPerson) {
        this.approvalPerson = approvalPerson;
    }

    public String getApprovalSuggestion() {
        return approvalSuggestion;
    }

    public void setApprovalSuggestion(String approvalSuggestion) {
        this.approvalSuggestion = approvalSuggestion;
    }

    public String getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(String approvalTime) {
        this.approvalTime = approvalTime;
    }
}
