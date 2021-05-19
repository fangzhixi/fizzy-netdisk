package com.fizzy.util.sdk;

import org.junit.Test;

public class AutographTest {

    @Test
    public void tokenInvoice() {
        String message = "DWosD6K3J/Qtl8rQfjTZN4dLGmRyqT4LrWc0xKglGpdsM/sBeyaqUsL2/bL/JHk7WlRwOnlR9IAynYcVJcVbE0APJfWHl6NkwfUjIuXTMNjZSsSELEUR+/LNFBHuyvhT2CyftutaQz254q2MPpCP/f6Wlsc8W98iHJaftIBl48bqFqMvYBgN7Heu/zTtrIqSXxheXVI2kI8XHfbV86GanILpkN53gY2Vxb1pfabQ6wOiKl6ojVQ1wnSIxjHuOcBNPXkMeY2YttSzIFtbdOem+CGbB57VYvIzi7usIQoTDF4PLgJAm6exaNENyOyfPerMPoGwiqACVNpZRMQbVTVpqA==";
        Autograph autograph = new Autograph(message);
        System.out.println("验证前数据: " + autograph.toString());
        System.out.println(autograph.slaveInvoice());
        System.out.println("验证后数据: " + autograph.toString());
    }
}