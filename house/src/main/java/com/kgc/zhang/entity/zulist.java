package com.kgc.zhang.entity;

public class zulist extends zulistKey {
    private Double price;

    private String address;

    private Integer userlistId;

    private Integer contractId;
    private  hetong hetong;

    private  userlist userlist;
    private  houselist houselist;

    public com.kgc.zhang.entity.houselist getHouselist() {
        return houselist;
    }

    public void setHouselist(com.kgc.zhang.entity.houselist houselist) {
        this.houselist = houselist;
    }

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

    public com.kgc.zhang.entity.hetong getHetong() {
        return hetong;
    }

    public void setHetong(com.kgc.zhang.entity.hetong hetong) {
        this.hetong = hetong;
    }

    public com.kgc.zhang.entity.userlist getUserlist() {
        return userlist;
    }

    public void setUserlist(com.kgc.zhang.entity.userlist userlist) {
        this.userlist = userlist;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getUserlistId() {
        return userlistId;
    }

    public void setUserlistId(Integer userlistId) {
        this.userlistId = userlistId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }
}