package sample;

import java.io.Serializable;

public class Treatment implements prescription, Serializable {
    private String treatmentId;
    private String treatmentName;
    private String treatmentLevel;
    private String hospitalLevel;
    private boolean isLabeled;
    private String price;
    private String remark;

    public Treatment() {

    }

    public Treatment(String treatmentId, String treatmentName, String treatmentLevel,
                     String hospitalLevel, boolean isLabeled, String manufacturer, String remark) {
        this.treatmentId = treatmentId;
        this.treatmentName = treatmentName;
        this.treatmentLevel = treatmentLevel;
        this.hospitalLevel = hospitalLevel;
        this.isLabeled = isLabeled;
        this.price = manufacturer;
        this.remark = remark;
    }


    public String  getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(String treatmentId) {
        this.treatmentId = treatmentId;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public String getTreatmentLevel() {
        return treatmentLevel;
    }

    public void setTreatmentLevel(String treatmentLevel) {
        this.treatmentLevel = treatmentLevel;
    }

    public String getHospitalLevel() {
        return hospitalLevel;
    }

    public void setHospitalLevel(String hospitalLevel) {
        this.hospitalLevel = hospitalLevel;
    }

    public boolean isLabeled() {
        return isLabeled;
    }

    public void setLabeled(boolean labeled) {
        isLabeled = labeled;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
