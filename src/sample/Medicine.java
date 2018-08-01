package sample;

/*
 * 该类主要负责药物的描述
 * @author: 杨越
 * @version: v1
 * */


import java.io.Serializable;

public class Medicine implements Serializable {
    private static final long serialVersionUID = 8504896965939479380L;
    private String medicineId;
    private String medicineNameCh;
    private String medicineNameEn;
    private String medicineLevel;
    private boolean isLabeled;
    private boolean isInCategory;
    private String idInCategory;
    private String hospitalPrice;
    private String ceterPrice;
    private String hospitalLevel;
    private String dosageForm;
    private String frequency;
    private String usageMethod;
    private String unit;
    private String size;
    private String restrictNumberOfDay;
    private String nameOfFactory;
    private String placeOfProduction;
    private String remark;

    /*
    * 构造器
    * */
    public Medicine() {

    }

    public Medicine(String medicineId, String medicineNameCh, String medicineNameEn,
                    String medicineLevel, boolean isLabeled, boolean isInCategory,
                    String idInCategory, String hospitalPrice, String hospitalLevel,
                    String dosageForm, String frequency, String usageMethod,
                    String unit, String size, String restrictNumberOfDay,
                    String nameOfFactory, String placeOfProduction, String remark,
                    String centerPrice) {
        this.ceterPrice = centerPrice;
        this.medicineId = medicineId;
        this.medicineNameCh = medicineNameCh;
        this.medicineNameEn = medicineNameEn;
        this.medicineLevel = medicineLevel;
        this.isLabeled = isLabeled;
        this.isInCategory = isInCategory;
        this.idInCategory = idInCategory;
        this.hospitalPrice = hospitalPrice;
        this.hospitalLevel = hospitalLevel;
        this.dosageForm = dosageForm;
        this.frequency = frequency;
        this.usageMethod = usageMethod;
        this.unit = unit;
        this.size = size;
        this.restrictNumberOfDay = restrictNumberOfDay;
        this.nameOfFactory = nameOfFactory;
        this.placeOfProduction = placeOfProduction;
        this.remark = remark;
    }

    public String getCeterPrice() {
        return ceterPrice;
    }

    public void setCeterPrice(String ceterPrice) {
        this.ceterPrice = ceterPrice;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineNameCh() {
        return medicineNameCh;
    }

    public void setMedicineNameCh(String medicineNameCh) {
        this.medicineNameCh = medicineNameCh;
    }

    public String getMedicineNameEn() {
        return medicineNameEn;
    }

    public void setMedicineNameEn(String medicineNameEn) {
        this.medicineNameEn = medicineNameEn;
    }

    public String getMedicineLevel() {
        return medicineLevel;
    }

    public void setMedicineLevel(String medicineLevel) {
        this.medicineLevel = medicineLevel;
    }

    public boolean isLabeled() {
        return isLabeled;
    }

    public void setLabeled(boolean labeled) {
        isLabeled = labeled;
    }

    public boolean isInCategory() {
        return isInCategory;
    }

    public void setInCategory(boolean inCategory) {
        isInCategory = inCategory;
    }

    public String getIdInCategory() {
        return idInCategory;
    }

    public void setIdInCategory(String idInCategory) {
        this.idInCategory = idInCategory;
    }

    public String getHospitalPrice() {
        return hospitalPrice;
    }

    public void setHospitalPrice(String hospitalPrice) {
        this.hospitalPrice = hospitalPrice;
    }

    public String getHospitalLevel() {
        return hospitalLevel;
    }

    public void setHospitalLevel(String hospitalLevel) {
        this.hospitalLevel = hospitalLevel;
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getUsageMethod() {
        return usageMethod;
    }

    public void setUsageMethod(String usageMethod) {
        this.usageMethod = usageMethod;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getRestrictNumberOfDay() {
        return restrictNumberOfDay;
    }

    public void setRestrictNumberOfDay(String restrictNumberOfDay) {
        this.restrictNumberOfDay = restrictNumberOfDay;
    }

    public String getNameOfFactory() {
        return nameOfFactory;
    }

    public void setNameOfFactory(String nameOfFactory) {
        this.nameOfFactory = nameOfFactory;
    }

    public String getPlaceOfProduction() {
        return placeOfProduction;
    }

    public void setPlaceOfProduction(String placeOfProduction) {
        this.placeOfProduction = placeOfProduction;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

