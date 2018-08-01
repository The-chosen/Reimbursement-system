package sample;

/*
 * 该类主要负责诊疗的描述
 * @author: 杨越
 * @version: v1
 * */

import java.io.Serializable;

public class Treatment implements Serializable {
    private static final long serialVersionUID = 8504896965939479380L;
    private String treatmentId;
    private String treatmentName;
    private String treatmentLevel;
    private String hospitalLevel;
    private boolean isLabeled;
    private String price;
    private String remark;
/*
* 构造器
* */
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
