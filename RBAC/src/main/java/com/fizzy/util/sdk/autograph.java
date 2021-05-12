package com.fizzy.util.sdk;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;

//签名认证
public class autograph extends RSAEncryption {

    private String signature;//加密后得到的签名串

    public autograph() {
        signature = "";
    }

    public autograph(String algorithm, String userID, Integer nonce, Long timestamp, String masterKey) {
        super(algorithm, userID, nonce, timestamp, masterKey);
        signature = "";
    }

    public String format(){
        String encryption = super.format();
        if (signature != "")
            encryption += ",signature=" + getSignature();
        return encryption;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * sha256_HMAC加密方式
     * @param message 消息
     * @param secretKey  秘钥
     * @return 加密后字符串
     */
    public static String sha256_HMAC(String message, String secretKey) {
        System.out.println("待SHA签名串："+message);
        String result = "";
        try
        {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(message.getBytes("utf-8"));
            result = DatatypeConverter.printBase64Binary(bytes);
        } catch (Exception e)
        {
            System.out.println(" HmacSHA256 签名失败 ===========" + e.getMessage());
        }
        return result;
    }

    public static String md5(String src) {
        String md5str = "";
        try {
            MessageDigest md    = MessageDigest.getInstance("MD5");
            byte[]        input = src.getBytes();
            byte[]        buff  = md.digest(input);
            md5str = toHex(buff);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5str;
    }

    private static String toHex(byte[] arr) {
        StringBuilder md5str = new StringBuilder();
        int           digital;
        for (byte anArr : arr) {
            digital = anArr;
            if (digital < 0) {
                digital += 256;
            }
            if (digital < 16) {
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString().toLowerCase();
    }
}
