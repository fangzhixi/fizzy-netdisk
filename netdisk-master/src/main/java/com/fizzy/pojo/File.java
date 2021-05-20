package com.fizzy.pojo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class File {

    private Integer elementId;//元素编号
    private Integer parentElementId;//父元素
    private Integer userId;//文件所属用户id
    private String fileName;//文件名
    private Integer fileSize;//文件大小
    private Integer fileType;//文件类型
    private String typeImageUrl;//文件类型图片
    private String fileUrl;//文件地址
    private Date createTime;//创建时间
    private Date updateTime;//更新时间

    public File() {
    }

    public File(File file) {
        this.elementId = file.elementId;
        this.parentElementId = file.parentElementId;
        this.userId = file.userId;
        this.fileName = file.fileName;
        this.fileSize = file.fileSize;
        this.fileType = file.fileType;
        this.typeImageUrl = file.typeImageUrl;
        this.fileUrl = file.fileUrl;
        this.createTime = file.createTime;
        this.updateTime = file.updateTime;
    }

    public Integer getElementId() {
        return elementId;
    }

    public void setElementId(Integer elementId) {
        this.elementId = elementId;
    }

    public File buildElementId(Integer elementId) {
        this.elementId = elementId;
        return this;
    }

    public Integer getParentElementId() {
        return parentElementId;
    }

    public void setParentElementId(Integer parentElementId) {
        this.parentElementId = parentElementId;
    }

    public File buildParentElementId(Integer parentElementId) {
        this.parentElementId = parentElementId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public File buildUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public File buildFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public File buildFileSize(Integer fileSize) {
        this.fileSize = fileSize;
        return this;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public File buildFileType(Integer fileType) {
        this.fileType = fileType;
        return this;
    }

    public String getTypeImageUrl() {
        return typeImageUrl;
    }

    public void setTypeImageUrl(String typeImageUrl) {
        this.typeImageUrl = typeImageUrl;
    }

    public File buildTypeImageUrl(String typeImageUrl) {
        this.typeImageUrl = typeImageUrl;
        return this;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public File buildFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public File buildCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public File buildUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public File build() {
        return new File(this);
    }

    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("element_id", getElementId());
        map.put("parent_element_id", getParentElementId());
        map.put("user_id", getUserId());
        map.put("file_name", getFileName());
        map.put("file_size", getFileSize());
        map.put("file_type", getFileType());
        map.put("type_image", getTypeImageUrl());
        map.put("file_url", getFileUrl());
        map.put("create_time", getCreateTime());
        map.put("update_time", getUpdateTime());
        return map;
    }

    @Override
    public String toString() {
        return "File{" +
                "elementId=" + elementId +
                ", parentElementId=" + parentElementId +
                ", userId=" + userId +
                ", fileName='" + fileName + '\'' +
                ", fileSize=" + fileSize +
                ", fileType=" + fileType +
                ", typeImageUrl='" + typeImageUrl + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
