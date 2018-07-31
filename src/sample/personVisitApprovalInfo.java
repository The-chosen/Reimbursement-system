package sample;

import java.io.Serializable;

public class personVisitApprovalInfo implements Serializable{
    private String approvalId;
    private String personId;
    private time beginTime;
    private time endTime;
    private String fixedHospitalId;
    private String approvalPerson;
    private String approvalSuggestion;
    private String approvalTime;

    public personVisitApprovalInfo(String approvalId, String personId, time beginTime,
                                   time endTime, String fixedHospitalId, String approvalPerson,
                                   String approvalSuggestion, String approvalTime) {
        this.approvalId = approvalId;
        this.personId = personId;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.fixedHospitalId = fixedHospitalId;
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

    public String getFixedHospitalId() {
        return fixedHospitalId;
    }

    public void setFixedHospitalId(String fixedHospitalId) {
        this.fixedHospitalId = fixedHospitalId;
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
