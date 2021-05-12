package com.fizzy.query;

public class CustomerQueryObject extends QueryObject{

    private String keyword;
    private Integer status;
    private Integer sellerId;

    public CustomerQueryObject() {
        this.keyword = null;
        this.status = -1;
        this.sellerId = -1;
    }


    public CustomerQueryObject(String keyword, Integer status, Integer sellerId) {
        this.keyword = keyword;
        this.status = status;
        this.sellerId = sellerId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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
        return "CustomerQueryObject{" +
                "keyword='" + keyword + '\'' +
                ", status='" + status + '\'' +
                ", sellerId=" + sellerId +
                '}';
    }
}
