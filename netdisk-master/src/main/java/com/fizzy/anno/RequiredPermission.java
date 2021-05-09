package com.fizzy.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//指定这个方法必须在这个方法上面
@Retention(RetentionPolicy.RUNTIME)//指定存活周期
public @interface RequiredPermission {

    String[] value();
}
