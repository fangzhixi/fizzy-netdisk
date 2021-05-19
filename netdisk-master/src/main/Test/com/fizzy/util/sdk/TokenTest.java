package com.fizzy.util.sdk;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;

public class TokenTest {

    @Test
    public void tokenInvoice() {
        String message = "DWosD6K3J/Qtl8rQfjTZN4dLGmRyqT4LrWc0xKglGpdsM/sBeyaqUsL2/bL/JHk7WlRwOnlR9IAynYcVJcVbE0APJfWHl6NkwfUjIuXTMNjZSsSELEUR+/LNFBHuyvhT2CyftutaQz254q2MPpCP/f6Wlsc8W98iHJaftIBl48bqFqMvYBgN7Heu/zTtrIqSXxheXVI2kI8XHfbV86GanILpkN53gY2Vxb1pfabQ6wOiKl6ojVQ1wnSIxjHuOcBNPXkMeY2YttSzIFtbdOem+CGbB57VYvIzi7usIQoTDF4PLgJAm6exaNENyOyfPerMPoGwiqACVNpZRMQbVTVpqA==";
        Token token = new Token(message);
        System.out.println("验证前数据: " + token.toString());
        System.out.println(token.tokenInvoice());
        System.out.println("验证后数据: " + token.toString());
    }
}