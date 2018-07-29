package sample;

import java.util.ArrayList;

public class prescriptionDetail {
    private String outpatientNumber;
    private ArrayList<prescription> medicineLs;

    public prescriptionDetail() {

    }

    public prescriptionDetail(String outpatientNumber, ArrayList<prescription> medicineLs) {
        this.outpatientNumber = outpatientNumber;
        this.medicineLs = medicineLs;
    }

    public String getOutpatientNumber() {
        return outpatientNumber;
    }

    public void setOutpatientNumber(String outpatientNumber) {
        this.outpatientNumber = outpatientNumber;
    }

    public ArrayList<prescription> getMedicineLs() {
        return medicineLs;
    }

    public void setMedicineLs(ArrayList<prescription> medicineLs) {
        this.medicineLs = medicineLs;
    }
}
