package sample;

/*
 * 该类主要负责服务设施的描述
 * @author: 杨越
 * @version: v1
 * */

import java.io.Serializable;

public class ServiceFacility implements Serializable{
    private static final long serialVersionUID = 8504896965939479380L;
    private String facilityName;
    private String facilityId;
    private String remark;
/*
* 构造器
* */
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
