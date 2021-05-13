package com.fizzy.util.sdk;


import org.apache.ibatis.jdbc.Null;

import java.util.*;

//Token认证
public class Token extends RSAEncryption {

    private String signature;//加密后得到的签名串
    private final Long TIME_OUT = 1200L;//过期时间20分钟(1200毫秒)

    public Token(String signature) {
        this.signature = signature;
    }

    public Token(String algorithm, String userID, Integer nonce, Long timestamp, String masterKey) {
        super(algorithm, userID, nonce, timestamp, masterKey);
        this.signature = "";
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * 签名验证(true通过,false不通过)[以MHAC-SHA-256解密方式为例]
     * Token按照以下方式排列: algorithm=解密方式,userID=用户ID,nonce=随机数字(推荐6位),timestamp=到期时间戳(10位),masterKey=主机认证口令
     * 样例: 				  algorithm=RSA-SHA256,userID=17820478359,nonce=169081,timestamp=1620454429,masterKey=KohIzIccGD6wNMnDCPeGf
     * <p>
     * 加密后的token格式:     Base64格式密码串
     * 样例:				  nft7AMsMTUguKohIzIccGD6wNMnDCPeGfxHMAEHmSfGA
     * |<---          Base64格式密码串          --->|
     * <p>
     * 认证逻辑:
     * 1.将获取的token原始字符串用Base64解码
     * 2.用密钥将token解密
     * 3.比对主机认证口令与本机储存主机认证口令是否一致
     * 4.所有认证均符合则通过，反之则不通过
     */
    public boolean tokenInvoice() {

        Long now = new Date().getTime();//获取当前时间

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

        System.out.println("3-5.封装token信息");
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

//        System.out.printf("4.比对token时间是否有效(默认过期时间:%d毫秒)\n",TIME_OUT);
//        if (now > Long.parseLong(tokenMap.get("timestamp"))){
//            System.out.println("当前时间已过期");
//            return false;
//        }

        System.out.println("5.比对主机认证口令与本机储存主机认证口令是否一致");
        String masterKey = Token.getMasterKey();
        if (masterKey.equals(tokenMap.get("masterKey"))) {
            System.out.println("5-5.验证通过,在token存放数据");
            this.setAlgorithm(tokenMap.get("algorithm"));
            this.setUserID(tokenMap.get("userID"));
            this.setNonce(Integer.parseInt(tokenMap.get("nonce")));
            this.setTimestamp(now + TIME_OUT);//设置过期时间 = 当前时间 + 过期时间
            return true;
        } else {
            return false;
        }
    }
}
