package sample;

import java.io.Serializable;

public class FixedMedicalInstitution implements Serializable {
    private String institutionId;
    private String institutionName;
    private String institutionLevel;
    private String institutionCategory;
    private String zipCode;
    private String legalRepresentativeName;
    private String legalRepresentativePho;
    private String contadctorTele;
    private String contactorPho;
    private String address;
    private String remark;

    public FixedMedicalInstitution() {

    }

    public FixedMedicalInstitution(String institutionId, String institutionName, String institutionLevel,
                                   String institutionCategory, String zipCode, String legalRepresentativeName,
                                   String legalRepresentativePho, String contadctorTele, String contactorPho,
                                   String address, String remark) {
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.institutionLevel = institutionLevel;
        this.institutionCategory = institutionCategory;
        this.zipCode = zipCode;
        this.legalRepresentativeName = legalRepresentativeName;
        this.legalRepresentativePho = legalRepresentativePho;
        this.contadctorTele = contadctorTele;
        this.contactorPho = contactorPho;
        this.address = address;
        this.remark = remark;
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

    public String getInstitutionLevel() {
        return institutionLevel;
    }

    public void setInstitutionLevel(String institutionLevel) {
        this.institutionLevel = institutionLevel;
    }

    public String getInstitutionCategory() {
        return institutionCategory;
    }

    public void setInstitutionCategory(String institutionCategory) {
        this.institutionCategory = institutionCategory;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getLegalRepresentativeName() {
        return legalRepresentativeName;
    }

    public void setLegalRepresentativeName(String legalRepresentativeName) {
        this.legalRepresentativeName = legalRepresentativeName;
    }

    public String getLegalRepresentativePho() {
        return legalRepresentativePho;
    }

    public void setLegalRepresentativePho(String legalRepresentativePho) {
        this.legalRepresentativePho = legalRepresentativePho;
    }

    public String getContadctorTele() {
        return contadctorTele;
    }

    public void setContadctorTele(String contadctorTele) {
        this.contadctorTele = contadctorTele;
    }

    public String getContactorPho() {
        return contactorPho;
    }

    public void setContactorPho(String contactorPho) {
        this.contactorPho = contactorPho;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
