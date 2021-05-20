package com.fizzy.pojo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class User {
    private Integer userId;//用户编号
    private String phone;//大陆手机号(账号)
    private String email;//邮箱(账号)
    private String password;//密码
    private String name;//名字
    private Integer sex;//0:女 1:男
    private String userPhoto;//用户头像
    private Integer type;//0:超级管理员 1:用户 2:管理员
    private Date createTime;//创建时间
    private Date updateTime;//更新时间

    public User() {
    }

    public User(User User) {
        this.userId = User.userId;
        this.phone = User.phone;
        this.email = User.email;
        this.password = User.password;
        this.name = User.name;
        this.sex = User.sex;
        this.userPhoto = User.userPhoto;
        this.type = User.type;
        this.createTime = User.createTime;
        this.updateTime = User.updateTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User buildUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User buildPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User buildEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User buildPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User buildName(String name) {
        this.name = name;
        return this;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public User buildSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public User buildUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public User buildType(Integer type) {
        this.type = type;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User buildCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public User buildUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public User build(){
        return new User(this);
    }

    public Map<String,Object> getMap(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("user_id",getUserId());
        map.put("phone",getPhone());
        map.put("email",getEmail());
        map.put("password",getPassword());
        map.put("name",getName());
        map.put("sex",getSex());
        map.put("user_photo",getUserPhoto());
        map.put("type",getType());
        map.put("create_time",getCreateTime());
        map.put("update_time",getUpdateTime());
        return map;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", userPhoto='" + userPhoto + '\'' +
                ", type=" + type +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

