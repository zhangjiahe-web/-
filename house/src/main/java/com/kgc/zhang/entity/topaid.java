package com.kgc.zhang.entity;

import java.util.Date;

public class topaid {
    private Integer id;

    private String houseId;

    private String address;

    private Double price;

    private Date date;

    private String name;

    private Integer userlistId;

    private String status;

    private  userlist userlist;
    private  houselist houselist;

    public com.kgc.zhang.entity.userlist getUserlist() {
        return userlist;
    }

    public void setUserlist(com.kgc.zhang.entity.userlist userlist) {
        this.userlist = userlist;
    }

    public com.kgc.zhang.entity.houselist getHouselist() {
        return houselist;
    }

    public void setHouselist(com.kgc.zhang.entity.houselist houselist) {
        this.houselist = houselist;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getUserlistId() {
        return userlistId;
    }

    public void setUserlistId(Integer userlistId) {
        this.userlistId = userlistId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}