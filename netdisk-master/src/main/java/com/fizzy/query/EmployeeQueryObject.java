package com.fizzy.query;

public class EmployeeQueryObject extends QueryObject {

    private Integer deptId;
    private String keyword;
    private String status;
    private Integer sellerId;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public String toString() {
        return "EmployeeQueryObject{" +
                "deptId=" + deptId +
                ", keyword='" + keyword + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
