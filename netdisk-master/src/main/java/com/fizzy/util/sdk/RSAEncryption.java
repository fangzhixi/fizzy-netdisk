package com.fizzy.util.sdk;

import org.apache.commons.codec.binary.Base64;
import org.springframework.core.io.ClassPathResource;

import javax.crypto.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

//加密实现类(父类)
public class RSAEncryption {

    /**
     * 获取主机口令文件内容
     * (口令文件位置:classpath:keystore/master-attestation.key)
     *
     * @return 主机口令内容
     * @throws IOException
     */
    public static String getMasterKey() {
        // ClassPathResource类的构造方法接收路径名称，自动去classpath路径下找文件
        ClassPathResource classPathResource = new ClassPathResource("keystore/master-attestation.key");

        // 获得File对象，当然也可以获取输入流对象
        StringBuilder content = null;
        try {
            File file = classPathResource.getFile();

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            content = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("使用的主机口令内容为:\n" + content.toString());
        return content.toString();
    }

    /**
     * 获取公钥文件内容
     *
     * @return 公钥内容
     * @throws IOException
     */
    private static String getPublicKey() throws IOException {
        // ClassPathResource类的构造方法接收路径名称，自动去classpath路径下找文件
        ClassPathResource classPathResource = new ClassPathResource("keystore/public_key.pkcs8");

        // 获得File对象，当然也可以获取输入流对象
        File file = classPathResource.getFile();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder content = new StringBuilder();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            content.append(line);
        }
        System.out.println("使用的公钥内容为:\n" + content.toString());
        return content.toString();
    }

    /**
     * 获取私钥文件内容
     *
     * @return 私钥内容
     * @throws IOException
     */
    private static String getPrivateKey() throws IOException {
        // ClassPathResource类的构造方法接收路径名称，自动去classpath路径下找文件
        ClassPathResource classPathResource = new ClassPathResource("keystore/private_key.pkcs8");

        // 获得File对象，当然也可以获取输入流对象
        File file = classPathResource.getFile();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder content = new StringBuilder();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            content.append(line);
        }
        System.out.println("使用的私钥内容为:\n" + content.toString());
        return content.toString();
    }

    /**
     * RSA公钥加密
     *
     * @param originData 加密源数据
     * @throws Exception 加密过程中的异常信息
     * @return
     */
    public static String rsaEncryptOutBase64(String originData) {
        //base64编码的公钥
        String outStr = "";
        try {
            byte[] decoded = Base64.decodeBase64(getPublicKey());
            RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
            //RSA加密
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            outStr = Base64.encodeBase64String(cipher.doFinal(originData.getBytes("UTF-8")));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return outStr;
    }


    /**
     * RSA私钥解密
     *
     * @param cipherBase64 加密后的base64转译数据
     * @return 解密后的原文
     * @throws Exception 解密过程中的异常信息
     */
    public static String rsaDecryptByBase64(String cipherBase64) {
        String outStr = null;
        try {
            //数据校验
            if (cipherBase64 == null || "".equals(cipherBase64)) {
                return outStr;
            }

            //64位解码加密后的字符串
            byte[] inputByte = Base64.decodeBase64(cipherBase64.getBytes("UTF-8"));
            //base64编码的私钥
            byte[] decoded = Base64.decodeBase64(getPrivateKey());
            RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
            //RSA解密
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, priKey);
            outStr = new String(cipher.doFinal(inputByte));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return outStr;
    }
}
