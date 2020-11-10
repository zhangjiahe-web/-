package com.kgc.zhang.entity;

public class applyout {
    private Integer aoid;

    private String houseId;

    private String address;

    private String status;

    private Integer userlistId;
    private houselist houselist;
    private userlist userlist;

    private String idcard;

    private String name;

    private String phone;

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public com.kgc.zhang.entity.houselist getHouselist() {
        return houselist;
    }

    public void setHouselist(com.kgc.zhang.entity.houselist houselist) {
        this.houselist = houselist;
    }

    public com.kgc.zhang.entity.userlist getUserlist() {
        return userlist;
    }

    public void setUserlist(com.kgc.zhang.entity.userlist userlist) {
        this.userlist = userlist;
    }

    public Integer getAoid() {
        return aoid;
    }

    public void setAoid(Integer aoid) {
        this.aoid = aoid;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId == null ? null : houseId.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getUserlistId() {
        return userlistId;
    }

    public void setUserlistId(Integer userlistId) {
        this.userlistId = userlistId;
    }
}