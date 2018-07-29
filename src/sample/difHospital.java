package sample;

public class difHospital {
    private String approveId;
    private String hospitalId;
    private String personId;
    private String beginId;
    private String endId;
    private boolean isApproved;

    public difHospital() {

    }

    public difHospital(String approveId, String hospitalId, String personId,
                       String beginId, String endId, boolean isApproved) {
        this.approveId = approveId;
        this.hospitalId = hospitalId;
        this.personId = personId;
        this.beginId = beginId;
        this.endId = endId;
        this.isApproved = isApproved;
    }

    public String getApproveId() {
        return approveId;
    }

    public void setApproveId(String approveId) {
        this.approveId = approveId;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getBeginId() {
        return beginId;
    }

    public void setBeginId(String beginId) {
        this.beginId = beginId;
    }

    public String getEndId() {
        return endId;
    }

    public void setEndId(String endId) {
        this.endId = endId;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}
