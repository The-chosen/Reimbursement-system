package sample;
/*
 * 该类主要负责时间的描述
 * @author: 杨越
 * @version: v1
 * */

import java.io.Serializable;

class time implements Serializable{
    private static final long serialVersionUID = 8504896965939479380L;
    private String year;
    private String month;
    private String date;

    /*
    * 构造器
    * */

    public time(String year, String month, String date) {
        this.year = year;
        this.month = month;
        this.date = date;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}