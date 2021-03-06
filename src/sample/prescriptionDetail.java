package sample;

/*
 * 该类主要负责处方信息的描述
 * @author: 杨越
 * @version: v1
 * */


import java.io.Serializable;
import java.util.ArrayList;

public class prescriptionDetail implements Serializable{
    private static final long serialVersionUID = 8504896965939479380L;
    private String outpatientNumber;
    private ArrayList<Medicine> medicineLs = new ArrayList<>();
    private ArrayList<Treatment> treatmentLs = new ArrayList<>();
    private ArrayList<ServiceFacility> serviceFacilityLs = new ArrayList<>();

    /*
    * 构造器
    * */

    public prescriptionDetail() {

    }

    public prescriptionDetail(String outpatientNumber, ArrayList<Medicine> medicineLs, ArrayList<Treatment> treatmentLs,
                              ArrayList<ServiceFacility> serviceFacilityLs) {
        this.outpatientNumber = outpatientNumber;
        this.medicineLs = medicineLs;
        this.treatmentLs = treatmentLs;
        this.serviceFacilityLs = serviceFacilityLs;
    }

    public String getOutpatientNumber() {
        return outpatientNumber;
    }

    public void setOutpatientNumber(String outpatientNumber) {
        this.outpatientNumber = outpatientNumber;
    }

    public ArrayList<Medicine> getMedicineLs() {
        return medicineLs;
    }

    public void setMedicineLs(ArrayList<Medicine> medicineLs) {
        this.medicineLs = medicineLs;
    }

    public ArrayList<Treatment> getTreatmentLs() {
        return treatmentLs;
    }

    public void setTreatmentLs(ArrayList<Treatment> treatmentLs) {
        this.treatmentLs = treatmentLs;
    }

    public ArrayList<ServiceFacility> getServiceFacilityLs() {
        return serviceFacilityLs;
    }

    public void setServiceFacilityLs(ArrayList<ServiceFacility> serviceFacilityLs) {
        this.serviceFacilityLs = serviceFacilityLs;
    }
}
