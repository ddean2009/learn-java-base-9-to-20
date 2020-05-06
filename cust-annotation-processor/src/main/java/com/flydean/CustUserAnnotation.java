package com.flydean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wayne
 * @version CustUser,  2020/5/5 10:41 下午
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface CustUserAnnotation {
    int value();
    String name();
    String[] addresses();
}
