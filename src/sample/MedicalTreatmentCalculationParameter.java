package sample;

/*
 * 该类主要负责医疗计算参数的描述
 * @author: 杨越
 * @version: v1
 * */

import java.io.Serializable;

public class MedicalTreatmentCalculationParameter implements Serializable{
    private static final long serialVersionUID = 8504896965939479380L;
    private String parameterId;
    private String medicalPeopleCategory;
    private String medicalCategory;
    private double thresholdPrice;
    private double cappingLine;
    private double upperLine;
    private double lowerLine;
    private double proportionOfReimbursement;

    public MedicalTreatmentCalculationParameter() {

    }

    /*
    * 构造器
    * */

    public MedicalTreatmentCalculationParameter(String parameterId, String medicalPeopleCategory, String medicalCategory,
                                                double thresholdPrice, double cappingLine, double upperLine,
                                                double lowerLine, double proportionOfReimbursement) {
        this.medicalPeopleCategory = medicalPeopleCategory;
        this.medicalCategory = medicalCategory;
        this.parameterId = parameterId;
        this.thresholdPrice = thresholdPrice;
        this.cappingLine = cappingLine;
        this.upperLine = upperLine;
        this.lowerLine = lowerLine;
        this.proportionOfReimbursement = proportionOfReimbursement;
    }


    public String getMedicalPeopleCategory() {
        return medicalPeopleCategory;
    }

    public void setMedicalPeopleCategory(String medicalPeopleCategory) {
        this.medicalPeopleCategory = medicalPeopleCategory;
    }

    public String getMedicalCategory() {
        return medicalCategory;
    }

    public void setMedicalCategory(String medicalCategory) {
        this.medicalCategory = medicalCategory;
    }

    public String getParameterId() {
        return parameterId;
    }

    public void setParameterId(String parameterId) {
        this.parameterId = parameterId;
    }

    public double getThresholdPrice() {
        return thresholdPrice;
    }

    public void setThresholdPrice(double thresholdPrice) {
        this.thresholdPrice = thresholdPrice;
    }

    public double getCappingLine() {
        return cappingLine;
    }

    public void setCappingLine(double cappingLine) {
        this.cappingLine = cappingLine;
    }

    public double getUpperLine() {
        return upperLine;
    }

    public void setUpperLine(double upperLine) {
        this.upperLine = upperLine;
    }

    public double getLowerLine() {
        return lowerLine;
    }

    public void setLowerLine(double lowerLine) {
        this.lowerLine = lowerLine;
    }

    public double getProportionOfReimbursement() {
        return proportionOfReimbursement;
    }

    public void setProportionOfReimbursement(double proportionOfReimbursement) {
        this.proportionOfReimbursement = proportionOfReimbursement;
    }
}