package com.kgc.zhang.entity;

public class userlist {
    private Integer id;

    private String idcard;
    private  user user;

    public com.kgc.zhang.entity.user getUser() {
        return user;
    }

    public void setUser(com.kgc.zhang.entity.user user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    @Override
    public String toString() {
        return "userlist{" +
                "id=" + id +
                ", idcard='" + idcard + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", userId=" + userId +
                '}';
    }

    private String name;

    private String phone;

    private Integer userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}