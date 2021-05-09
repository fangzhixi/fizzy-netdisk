package com.fizzy.pojo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {

    private Integer id;
    private String name;
    private boolean genderStr;
    private Integer age;
    private String tel;
    private String qq;
    private Job job;
    private Source source;
    private Seller seller;
    private String statusStr;
    private Date input_time;

    public Customer() {
        this.id = null;
        this.name = null;
        this.genderStr = true;
        this.age = null;
        this.tel = null;
        this.qq = null;
        this.job = null;
        this.source = null;
        this.seller = null;
        this.statusStr = null;
        this.input_time = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenderStr() {
        return genderStr ? "男" : "女";
    }

    public void setGenderStr(boolean genderStr) {
        this.genderStr = genderStr;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getInput_time() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        return input_time != null ? dateFormat.format(input_time) : null;
    }

    public void setInput_time(Date input_time) {
        this.input_time = input_time;
    }

    public String getStatusStr() {
        switch (statusStr)
        {
            case "0":return"潜在客户";
            case "1":return"正式客户";
            case "2":return"资源池客户";
            case "3":return"开发失败客户";
            case "4":return"流失客户";
            default:return "未知客户";
        }
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genderStr=" + genderStr +
                ", age=" + age +
                ", tel='" + tel + '\'' +
                ", qq='" + qq + '\'' +
                ", job=" + job +
                ", source=" + source +
                ", seller=" + seller +
                ", statusStr='" + statusStr + '\'' +
                ", input_time=" + input_time +
                '}';
    }
}
