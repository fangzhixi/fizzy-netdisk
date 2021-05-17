package com.fizzy.pojo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String userId;
    private String password;
    private String name;
    private Integer sex;
    private String phone;
    private String email;
    private String userPhoto;
    private Integer type;
    private Date createTime;
    private Date updateTime;

    public User() {
    }

    public User(User User) {
        this.userId = User.userId;
        this.password = User.password;
        this.name = User.name;
        this.sex = User.sex;
        this.phone = User.phone;
        this.email = User.email;
        this.userPhoto = User.userPhoto;
        this.type = User.type;
        this.createTime = User.createTime;
        this.updateTime = User.updateTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public User buildUserId(String userId) {
        this.userId = userId;
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
        map.put("password",getPassword());
        map.put("name",getName());
        map.put("sex",getSex());
        map.put("phone",getPhone());
        map.put("email",getEmail());
        map.put("user_photo",getUserPhoto());
        map.put("type",getType());
        map.put("create_time",getCreateTime());
        map.put("update_time",getUpdateTime());
        return map;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                ", type=" + type +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

