package sample;

import java.io.Serializable;

public class visitInfo implements Serializable {
    private String personId;
    private String medicalCategory;
    private String institutionId;
    private String institutionName;
    private time admissionTime;
    private time dischargeTime;
    private String institutionLevel;
    private String dischargeReason;
    private prescriptionDetail prescriptionDetail = new prescriptionDetail();

    public visitInfo() {

    }

    public visitInfo(String personId, String medicalCategory, String institutionId,
                     String institutionName, time admissionTime, time dischargeTime,
                     String institutionLevel, String dischargeReason, sample.prescriptionDetail prescriptionDetail) {
        this.personId = personId;
        this.medicalCategory = medicalCategory;
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.admissionTime = admissionTime;
        this.dischargeTime = dischargeTime;
        this.institutionLevel = institutionLevel;
        this.dischargeReason = dischargeReason;
        this.prescriptionDetail = prescriptionDetail;
    }

    public visitInfo(String personId, String medicalCategory, String institutionId,
                     String institutionName, time admissionTime, time dischargeTime,
                     String institutionLevel, String dischargeReason) {
        this.personId = personId;
        this.medicalCategory = medicalCategory;
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.admissionTime = admissionTime;
        this.dischargeTime = dischargeTime;
        this.institutionLevel = institutionLevel;
        this.dischargeReason = dischargeReason;
        this.prescriptionDetail = prescriptionDetail;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getMedicalCategory() {
        return medicalCategory;
    }

    public void setMedicalCategory(String medicalCategory) {
        this.medicalCategory = medicalCategory;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public time getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(time admissionTime) {
        this.admissionTime = admissionTime;
    }

    public time getDischargeTime() {
        return dischargeTime;
    }

    public void setDischargeTime(time dischargeTime) {
        this.dischargeTime = dischargeTime;
    }

    public String getInstitutionLevel() {
        return institutionLevel;
    }

    public void setInstitutionLevel(String institutionLevel) {
        this.institutionLevel = institutionLevel;
    }

    public String getDischargeReason() {
        return dischargeReason;
    }

    public void setDischargeReason(String dischargeReason) {
        this.dischargeReason = dischargeReason;
    }

    public sample.prescriptionDetail getPrescriptionDetail() {
        return prescriptionDetail;
    }

    public void setPrescriptionDetail(sample.prescriptionDetail prescriptionDetail) {
        this.prescriptionDetail = prescriptionDetail;
    }
}
