package com.fizzy.pojo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Slave {

    private String address;//网络地址(ipv4、ipv6、域名)
    private Long usedSpace;//已用空间
    private Long freeSpace;//剩余空间
    private String masterKey;//主机验证口令
    private Date createTime;//创建时间
    private Date updateTime;//更新时间

    public Slave() {
    }

    public Slave(Slave slaveBuilder) {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Slave buildAddress(String address) {
        this.address = address;
        return this;
    }

    public Long getUsedSpace() {
        return usedSpace;
    }

    public void setUsedSpace(Long usedSpace) {
        this.usedSpace = usedSpace;
    }

    public Slave buildUsedSpace(Long usedSpace) {
        this.usedSpace = usedSpace;
        return this;
    }

    public Long getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(Long freeSpace) {
        this.freeSpace = freeSpace;
    }

    public Slave buildFreeSpace(Long freeSpace) {
        this.freeSpace = freeSpace;
        return this;
    }

    public String getMasterKey() {
        return masterKey;
    }

    public void setMasterKey(String masterKey) {
        this.masterKey = masterKey;
    }

    public Slave buildMasterKey(String masterKey) {
        this.masterKey = masterKey;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Slave buildCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Slave buildUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Slave build(){
        return new Slave(this);
    }

    public Map<String,Object> getMap(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("address",getAddress());
        map.put("used_space",getUsedSpace());
        map.put("free_space",getFreeSpace());
        map.put("master_key",getMasterKey());
        map.put("create_time",getCreateTime());
        map.put("update_time",getUpdateTime());
        return map;
    }

    @Override
    public String toString() {
        return "Slave{" +
                ", address='" + address + '\'' +
                ", usedSpace=" + usedSpace +
                ", freeSpace=" + freeSpace +
                ", masterKey='" + masterKey + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
