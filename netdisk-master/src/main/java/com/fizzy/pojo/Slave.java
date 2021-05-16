package com.fizzy.pojo;

import java.util.Date;

public class Slave {

    private String address;//网络地址(ipv4、ipv6、域名)
    private Long usedSpace;//已用空间
    private Long freeSpace;//剩余空间
    private String masterKey;//主机验证口令
    private Date createTime;//创建时间
    private Date updateTime;//更新时间

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getUsedSpace() {
        return usedSpace;
    }

    public void setUsedSpace(Long usedSpace) {
        this.usedSpace = usedSpace;
    }

    public Long getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(Long freeSpace) {
        this.freeSpace = freeSpace;
    }

    public String getMasterKey() {
        return masterKey;
    }

    public void setMasterKey(String masterKey) {
        this.masterKey = masterKey;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
