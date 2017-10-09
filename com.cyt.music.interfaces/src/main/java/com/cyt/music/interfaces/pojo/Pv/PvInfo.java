package com.cyt.music.interfaces.pojo.Pv;

public class PvInfo {
    private Integer id;

    private String ip;

    private Integer mainPageCount;

    private Integer contactPageCount;

    private Integer morePageCount;

    private Integer payPageCount;

    private String country;

    private String date;

    private String remark;

    public PvInfo() {
        this.mainPageCount = 0;
        this.contactPageCount = 0;
        this.morePageCount = 0;
        this.payPageCount = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getMainPageCount() {
        return mainPageCount;
    }

    public void setMainPageCount(Integer mainPageCount) {
        this.mainPageCount = mainPageCount;
    }

    public Integer getContactPageCount() {
        return contactPageCount;
    }

    public void setContactPageCount(Integer contactPageCount) {
        this.contactPageCount = contactPageCount;
    }

    public Integer getMorePageCount() {
        return morePageCount;
    }

    public void setMorePageCount(Integer morePageCount) {
        this.morePageCount = morePageCount;
    }

    public Integer getPayPageCount() {
        return payPageCount;
    }

    public void setPayPageCount(Integer payPageCount) {
        this.payPageCount = payPageCount;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}