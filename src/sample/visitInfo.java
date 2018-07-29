package sample;

public class visitInfo {
    private int personId;
    private String medicalCategory;
    private String institutionId;
    private String institutionName;
    private String admissionDate;
    private String dischargeDate;
    private String institutionLevel;
    private String dischargeReason;
    private prescriptionDetail prescriptionDetail;

    public visitInfo() {

    }

    public visitInfo(int personId, String medicalCategory, String institutionId,
                     String institutionName, String admissionDate, String dischargeDate,
                     String institutionLevel, String dischargeReason, sample.prescriptionDetail prescriptionDetail) {
        this.personId = personId;
        this.medicalCategory = medicalCategory;
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.institutionLevel = institutionLevel;
        this.dischargeReason = dischargeReason;
        this.prescriptionDetail = prescriptionDetail;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
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

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
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
