package com.fizzy.util.sdk;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;

public class RSAEncryptTest {

    @Test
    public void rsaEncryptOutBase64() throws Exception {
        String message = "algorithm=HMAC-SHA256,userID=gd_abcdefghijklmn,nonce=398888,timestamp=1590719810,masterKey=-BEGIN MASTER KEY-X3gTwDsH0e0CeGH6DQ099UT3XJLL/zewIDAQABAoIBf1ZwF23mGcvfvNKM9dltM5BpxvaPGUWOpBqLln75NJVuTJKMD4Lh63mP2tWEmMTVezEowawEt1jK-END MASTER KEY-";
        String messageEn = RSAEncryption.rsaEncryptOutBase64(message);
        System.out.println(message + "\n加密后的字符串为:\n" + messageEn);
    }

    @Test
    public void rsaDecryptByBase64() throws Exception {
        //加密字符串
        String message = "algorithm=HMAC-SHA256,userID=gd_abcdefghijklmn,nonce=398888,timestamp=1590719810,masterKey=-BEGIN MASTER KEY-X3gTwDsH0e0CeGH6DQ099UT3XJLL/zewIDAQABAoIBf1ZwF23mGcvfvNKM9dltM5BpxvaPGUWOpBqLln75NJVuTJKMD4Lh63mP2tWEmMTVezEowawEt1jK-END MASTER KEY-";
        String messageEn = RSAEncryption.rsaEncryptOutBase64(message);
        System.out.println("加密源数据:\n" + message);
        System.out.println("加密后的字符串为:\n" + messageEn);
        String messageDe = RSAEncryption.rsaDecryptByBase64(messageEn);
        System.out.println("还原后的字符串为:\n" + messageDe);
    }
}