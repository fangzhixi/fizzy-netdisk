package com.fizzy.util.sdk;


import org.apache.ibatis.jdbc.Null;

import java.util.*;

//从机签名认证
public class Autograph extends RSAEncryption {

    private String algorithm;//加密规则(HMAC-SHA256、MD5)
    private String address;//从机地址（ipv4 、ipv6、域名）
    private Integer nonce;//随机数(推荐6位随机数字)
    private Long timestamp;//到期时间戳(10位数字)
    private String masterKey;//主机认证口令
    private String signature;//加密后得到的签名串

    public Autograph(String signature) {
        this.signature = signature;
    }

    public Autograph(String algorithm, String address, Integer nonce, Long timestamp, String masterKey) {
        this.algorithm = algorithm;
        this.address = address;
        this.nonce = nonce;
        this.timestamp = timestamp;
        this.masterKey = masterKey;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNonce() {
        return nonce;
    }

    public void setNonce(Integer nonce) {
        this.nonce = nonce;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public void setMasterKey(String masterKey) {
        this.masterKey = masterKey;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * 从机签名验证(true通过,false不通过)[以MHAC-SHA-256解密方式为例]
     * Authorization按照以下方式排列: algorithm=解密方式,address=ip地址,nonce=随机数字(推荐6位),masterKey=主机认证口令
     * 样例: 				  algorithm=RSA-SHA256,address=192.168.0.1,nonce=169081,timestamp=1620454429,masterKey=KohIzIccGD6wNMnDCPeGf
     *
     * 加密后的Authorization格式:     Base64格式密码串
     * 样例:				  nft7AMsMTUguKohIzIccGD6wNMnDCPeGfxHMAEHmSfGA
     *                   |<---          Base64格式密码串           --->|
     *
     * 认证逻辑:
     * 1.将获取的原始从机口令字符串用Base64解码
     * 2.用密钥将从机口令解密
     * 3.比对从机认证口令与本机储存主机认证口令是否一致
     * 4.所有认证均符合则通过，反之则不通过*/
    public boolean slaveInvoice() {

        System.out.println("1.数据验证");
        if ("".equals(this.getSignature())) {
            return false;
        }

        System.out.println("2.将获取的token原始字符串用Base64解码");
        System.out.println("3.用密钥将token解密");
        String message = rsaDecryptByBase64(this.signature); //解密
        if (message == null || "".equals(message)) {
            System.out.println("解密信息为空,校验不通过");
            return false;
        }
        System.out.println("解密后的数据:" + message);

        System.out.println("3-5.封装Autograph信息");
        String[] kVList = message.split(",");
        Map<String, String> tokenMap = new HashMap<String, String>();
        for (int i = 0; i < kVList.length; i++) {
            String[] kVItem = kVList[i].split("=");
            if (kVItem.length == 2) {
                String key = kVItem[0];
                String value = kVItem[1];
                tokenMap.put(key, value);
            } else {
                return false;
            }
        }
        System.out.println("5.比对主机认证口令与本机储存主机认证口令是否一致");
        String masterKey = Token.getMasterKey();
        if (masterKey.equals(tokenMap.get("masterKey"))) {
            System.out.println("5-5.验证通过,在Autograph存放数据");
            this.setAlgorithm(tokenMap.get("algorithm"));
            this.setAddress(tokenMap.get("address"));
            this.setNonce(Integer.parseInt(tokenMap.get("nonce")));
            this.setTimestamp(Long.parseLong(tokenMap.get("timestamp")));
            this.setMasterKey(tokenMap.get("masterKey"));
            return true;
        } else {
            return false;
        }
    }

    /**
     * 格式化输出
     *
     * @return signature
     */
    public String format() {
        String signature =
                "algorithm=" + getAlgorithm()
                        + ",address=" + getAddress()
                        + ",nonce=" + getNonce()
                        + ",timestamp=" + getTimestamp()
                        + ",masterKey=" + getMasterKey();
        return signature;
    }

    @Override
    public String toString() {
        return "Autograph{" +
                "algorithm='" + algorithm + '\'' +
                ", address='" + address + '\'' +
                ", nonce=" + nonce +
                ", timestamp=" + timestamp +
                ", masterKey='" + masterKey + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
