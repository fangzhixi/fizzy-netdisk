package com.fizzy.util.sdk.regular;

//正则表达式验证
public class Verification {

    private static final String REGEX_MOBILE = "^1[3|4|5|7|8][0-9]\\d{4,8}$";
    private static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    public static Boolean isPhone(String phone) {
        if (null == phone || "".equals(phone)) {
            return false;
        } else if (phone.matches(REGEX_MOBILE)) {
            System.out.println("是手机号");
            return true;
        } else {
            System.out.println("不是手机号");
            return false;
        }
    }

    public static boolean isEmail(String email) {
        if (null == email || "".equals(email)) {
            return false;
        }else if (email.matches(REGEX_EMAIL)) {
            System.out.println("是邮箱号");
            return true;
        } else {
            System.out.println("不是邮箱号");
            return false;
        }
    }
}
