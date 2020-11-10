package com.kgc.zhang.entity;

public class apply extends applyKey {
    private String address;

    private Double area;

    private Double price;

    private String status;

    private Integer userlistId;
    /*链表查询房东看租房申请 apply houselist userlist*/
    private  userlist userlist;
    private  houselist houselist;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    @Override
    public String toString() {
        return "apply{" +
                "address='" + address + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", userlistId=" + userlistId +
                '}';
    }
}