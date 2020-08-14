package com.flydean.threadsafe;

/**
 * @author wayne
 * @version ChildUnsafe1,  2020/8/14
 */
public class ChildUnsafe2 {

    public static ChildUnsafe2 childUnsafe2;
    int age;

    ChildUnsafe2(int age){
        this.age = age;
        childUnsafe2 = this;
    }
}
