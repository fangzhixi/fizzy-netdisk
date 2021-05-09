package com.fizzy.util.sdk;

public class Token {

    private String algorithm;//加密规则(HMAC-SHA256、MD5)
    private String userID;//用户名
    private Integer nonce;//随机数(推荐6位随机数字)
    private Integer timestamp;//时间戳

    public Token() {
    }

    public Token(String algorithm, String userID, Integer nonce, Integer timestamp) {
        this.algorithm = algorithm;
        this.userID = userID;
        this.nonce = nonce;
        this.timestamp = timestamp;
    }

    /**格式化输出
     *
     * @return signature
     */
    public String format() {
        String signature =
                "algorithm=" + getAlgorithm()
                        + "|userID=" + getUserID()
                        + "|nonce=" + getNonce()
                        + "|timestamp=" + getTimestamp();
        return signature;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Integer getNonce() {
        return nonce;
    }

    public void setNonce(Integer nonce) {
        this.nonce = nonce;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Token{" +
                ", algorithm='" + algorithm + '\'' +
                ", userID='" + userID + '\'' +
                ", nonce=" + nonce +
                ", timestamp=" + timestamp +
                '}';
    }
}
