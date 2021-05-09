package com.fizzy.util.sdk;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class RSAEncryptionTest {

    private static final String PRIVATE_KEY = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEowIBAAKCAQEA0I96W1O0JgAV/Gs1LhJnemRJ5eZUMJQK6oUAPvhwyKUs2T74\n" +
            "vJmChVxq9Iy1EEl0LgUp/YfFqFiiX0M6iLyEBAEi3o2b6wNFYDo/IzeOoryccaAL\n" +
            "AxpzddNpeqJGXqmEUOGz3x/EnNrutffsDqFkoD3X+oB2gNYByido0sF/2Fc9yyxE\n" +
            "3hKoW6Fm0S8SezjrKnYOx4Z+kCwWWF2gjTOqwI47E5GMD1npelDjw+2saOVgF9xT\n" +
            "qQMXa9mQx0FX2CafIwGfOaubIuSB81x7f4MfQaFZyKXjOiBJHDgcEo9xUS+O0ORu\n" +
            "gecYY/B7zg0xVfS0PShGhPfehl0ptSoblg/NsQIDAQABAoIBAF4i9Np2DJE+Zq4Z\n" +
            "gdZ6ziQrUkOn1AZdPBQg1jyWDOozy+t/Beyy6XvifBBH1o40aXFAOXTLLMdQwnF3\n" +
            "OdtwI7JfBOspReAtCMpnYAo4UHRZ589NqsrKzKS5ORn2VwbxQtzzEyo5/5fBJhAS\n" +
            "iIUOCgpd/7d89oAumH4zjZfbaSYvYgfCTNmzYUI9IuUjN/yjAEq1MwHMzK12APBl\n" +
            "MUIcTOtrR+H46nJIaqq6ktzpB1XrLLYImkiIhnfwuTDTXx4GJrL0zTaitB9uHFuJ\n" +
            "DkgiUUH/vnJrz1yatRbFfdiiiHKJM55V2QKaj0eEz9NWppCCy/oGGrwkXCYcMim3\n" +
            "dbUaQgECgYEA6AZBlrUE0ADhyEhhs+Lng2N5h2Dxeoeh50ZMfz8t3z/AwWQsd1dp\n" +
            "iJMm+j4STg5QJTR19+cjqlp4n2KGORNIpQhPBrVjuc8v/WoEnwl8OqMEwFBteu2D\n" +
            "YovuAjgB0OqAcldPzG7hhnrCw3MsMfqLcRDzcQnp/WuzuMwYvCPdwqECgYEA5hyH\n" +
            "bbrVB9fpLPRJVMy4I9pb5F06g72+h5mBCmT8bkqHx8mBnm5e60qFQsc0q062roYh\n" +
            "ehSZlivb3/EdVB5mss9d+240YmUFKwd1FFBKFux5PAvKIy7nBJS3I3wZFGbGCyUB\n" +
            "96JvLaARLPOn9V5kzR9LKfGOLxvsIvrmFukLQRECgYAUjilVXqgUfV+DTNZLB3kX\n" +
            "LMLheXcrMcToJlQ0mbZIpu8+ss81q2rQDKlRVhptC9uR0Dn7QmDogKdbB3F4sPqo\n" +
            "lDncEEnLdk18F95c8Iwu7a5IE1f/ofcXzenCDJAsn/nNJ2sMY25baZjDk/qAWv/r\n" +
            "fmLyyrwOFXKQlpRCZrMIwQKBgGinZPiE1kpA6i2l1Iwap0y3DL/pnqk37KVjLQr7\n" +
            "LstCXkqA3NCfRdAhDkZ2rv+SRwdMvYD2SXvA6rkIwdv2D6MXKJknX++4HgeZ1qes\n" +
            "dGXEmsayXfZuaGbu8/PRht5+d2euJxzm5UWM3QLiteqkSZf4uYiT8aR/QIAQOAEH\n" +
            "cDThAoGBAIkz2513XwBoBj+cXG3JD4ovSjSPpwChAVFb+PRZWEOF4N919TDObXyb\n" +
            "2ZLi9nS6IEMjlShoSKfpuQFUyFIi1VJeb16vV+M9iaAGUnpiX4tkLpsLB1sF3G2+\n" +
            "hSJ4WwCpbshURgLLo/l6E6n/4pAIPsCqgbARnlv5+QwoGMO3u2nb\n" +
            "-----END RSA PRIVATE KEY-----";

    private static final String MASTER_KEY = "-BEGIN MASTER KEY-BUXIENYA/t9BvCH8H3Lp+LDvB23oPOxoarea0PX/a8+7ac2G+wCb6XJ4QPj+meSve1pZJiEqxTyRfpdPF8CpItInaA6VHf7sWyBA0seEl23pKfa21uD4c-END MASTER KEY-";

    @Test
    public void format() {
        Token token = new Token("HMAC-SHA256",
                "gd_abcdefghijklmn",
                398888,
                1590719810,
                MASTER_KEY);
        String e = token.format();
        String result = Token.sha256_HMAC(e, PRIVATE_KEY);
        System.out.println(result);
    }

    @Test
    public void sha256_HMAC() {
        Token token = new Token("HMAC-SHA256",
                "gd_abcdefghijklmn",
                398888,
                1590719810,
                MASTER_KEY);
        token.setSignature(token.sha256_HMAC(token.format(), PRIVATE_KEY));
        System.out.println(token.getSignature());
    }
}