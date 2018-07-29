package sample;

import java.io.Serializable;

public class ServiceFacility implements prescription, Serializable{
    private String facilityName;
    private String facilityId;
    private String remark;

    public ServiceFacility() {

    }

    public ServiceFacility(String facilityName, String facilityId, String remark) {
        this.facilityName = facilityName;
        this.facilityId = facilityId;
        this.remark = remark;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
