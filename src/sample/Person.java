package sample;

import java.util.ArrayList;

public class Person {
    private int personId;
    private String personName;
    private String gender;
    private String birthday;
    private String documentCategory;
    private String documentIdentity;
    private String nationality;
    private String livePlace;
    private String phoneNumber;
    private double totalPrice;
    private ArrayList<visitInfo> visitInfoLs;
    private String designatedHospitalNumber;

    public Person() {

    }

    public Person(int personId, String personName, String gender,
                  String birthday, String documentCategory, String documentIdentity,
                  String nationality, String livePlace, String phoneNumber,
                  double totalPrice, ArrayList<visitInfo> visitInfoLs, String designatedHospitalNumber) {
        this.personId = personId;
        this.personName = personName;
        this.gender = gender;
        this.birthday = birthday;
        this.documentCategory = documentCategory;
        this.documentIdentity = documentIdentity;
        this.nationality = nationality;
        this.livePlace = livePlace;
        this.phoneNumber = phoneNumber;
        this.totalPrice = totalPrice;
        this.visitInfoLs = visitInfoLs;
        this.designatedHospitalNumber = designatedHospitalNumber;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDocumentCategory() {
        return documentCategory;
    }

    public void setDocumentCategory(String documentCategory) {
        this.documentCategory = documentCategory;
    }

    public String getDocumentIdentity() {
        return documentIdentity;
    }

    public void setDocumentIdentity(String documentIdentity) {
        this.documentIdentity = documentIdentity;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getLivePlace() {
        return livePlace;
    }

    public void setLivePlace(String livePlace) {
        this.livePlace = livePlace;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ArrayList<visitInfo> getVisitInfoLs() {
        return visitInfoLs;
    }

    public void setVisitInfoLs(ArrayList<visitInfo> visitInfoLs) {
        this.visitInfoLs = visitInfoLs;
    }

    public String getDesignatedHospitalNumber() {
        return designatedHospitalNumber;
    }

    public void setDesignatedHospitalNumber(String designatedHospitalNumber) {
        this.designatedHospitalNumber = designatedHospitalNumber;
    }
}
