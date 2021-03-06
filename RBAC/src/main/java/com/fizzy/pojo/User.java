package com.fizzy.pojo;

import java.util.Date;

public class User {
    private String userId;
    private String password;
    private String name;
    private Integer sex;
    private String phone;
    private String mail;
    private String user_Photo;
    private Integer type;
    private Date createDate;
    private Date updateDate;

    public User() {
    }

    public User(String userId,
                String password,
                String name,
                Integer sex,
                String phone,
                String mail,
                String user_Photo,
                Integer type,
                Date createDate,
                Date updateDate) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.mail = mail;
        this.user_Photo = user_Photo;
        this.type = type;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUser_Photo() {
        return user_Photo;
    }

    public void setUser_Photo(String user_Photo) {
        this.user_Photo = user_Photo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", user_Photo='" + user_Photo + '\'' +
                ", type=" + type +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
