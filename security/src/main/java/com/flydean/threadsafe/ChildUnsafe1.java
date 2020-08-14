package com.flydean.threadsafe;

/**
 * @author wayne
 * @version ChildUnsafe1,  2020/8/14
 */
public class ChildUnsafe1 {

    public static ChildUnsafe1 childUnsafe1;
    int age;

    ChildUnsafe1(int age){
        childUnsafe1 = this;
        this.age = age;
    }
}
