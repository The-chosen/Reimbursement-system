package sample;

/*
 * 该类主要负责参保人的描述
 * @author: 杨越
 * @version: v1
 * */

public class specialCheck {
    private String approveID;
    private String medicineId;
    private String personId;
    private String beginTime;
    private String endTIme;
    private boolean isApproved;

    public specialCheck() {

    }

    public specialCheck(String approveID, String medicineId, String personId,
                        String beginTime, String endTIme, boolean isApproved) {
        this.approveID = approveID;
        this.medicineId = medicineId;
        this.personId = personId;
        this.beginTime = beginTime;
        this.endTIme = endTIme;
        this.isApproved = isApproved;
    }

    public String getApproveID() {
        return approveID;
    }

    public void setApproveID(String approveID) {
        this.approveID = approveID;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTIme() {
        return endTIme;
    }

    public void setEndTIme(String endTIme) {
        this.endTIme = endTIme;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}
