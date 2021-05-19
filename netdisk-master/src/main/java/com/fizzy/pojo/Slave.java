package com.fizzy.pojo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Slave {

    private String uuid;//从机通用唯一识别码
    private String address;//网络地址(ipv4、ipv6、域名)
    private Long totalSpace;//总空间
    private Long usedSpace;//已用空间
    private String masterKey;//主机验证口令
    private Date createTime;//创建时间
    private Date updateTime;//更新时间

    public Slave() {
    }

    public Slave(Slave slaveBuilder) {
        this.uuid = slaveBuilder.uuid;
        this.address = slaveBuilder.address;
        this.totalSpace = slaveBuilder.totalSpace;
        this.usedSpace = slaveBuilder.usedSpace;
        this.masterKey = slaveBuilder.masterKey;
        this.createTime = slaveBuilder.createTime;
        this.updateTime = slaveBuilder.updateTime;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public Slave buildUuid(String uuid) {
        this.uuid = uuid;
        return this;
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

    public Long getTotalSpace() {
        return totalSpace;
    }

    public void setTotalSpace(Long totalSpace) {
        this.totalSpace = totalSpace;
    }

    public Slave buildTotalSpace(Long totalSpace) {
        this.totalSpace = totalSpace;
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

    public Slave build() {
        System.out.println("build data: " + this.toString());
        return new Slave(this);
    }

    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uuid", getUuid());
        map.put("address", getAddress());
        map.put("total_space", getTotalSpace());
        map.put("used_space", getUsedSpace());
        map.put("master_key", getMasterKey());
        map.put("create_time", getCreateTime());
        map.put("update_time", getUpdateTime());
        return map;
    }

    @Override
    public String toString() {
        return "Slave{" +
                "uuid='" + uuid + '\'' +
                ", address='" + address + '\'' +
                ", totalSpace=" + totalSpace +
                ", usedSpace=" + usedSpace +
                ", masterKey='" + masterKey + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
