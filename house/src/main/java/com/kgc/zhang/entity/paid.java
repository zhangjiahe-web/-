package com.kgc.zhang.entity;

import java.util.Date;

public class paid {
    private Integer id;

    private String houseId;

    private String address;

    private Double price;

    private Date date;

    private Date paydate;

    private String name;

    private Integer userlistId;

    private String status;
    private userlist userlist;
    private houselist houselist;

    private String idcard;

    private String phone;

    public paid(Integer id, String houseId, String address, Double price, Date date, Date paydate, String name, Integer userlistId, String status, com.kgc.zhang.entity.userlist userlist, com.kgc.zhang.entity.houselist houselist, String idcard, String name1, String phone) {
        this.id = id;
        this.houseId = houseId;
        this.address = address;
        this.price = price;
        this.date = date;
        this.paydate = paydate;
        this.name = name;
        this.userlistId = userlistId;
        this.status = status;
        this.userlist = userlist;
        this.houselist = houselist;
        this.idcard = idcard;
        this.name = name1;
        this.phone = phone;
    }

    public paid() {
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
        this.houseId = houseId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Date getPaydate() {
        return paydate;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
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
        this.status = status;
    }

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

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
}