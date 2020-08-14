package com.flydean.threadsafe;

/**
 * @author wayne
 * @version ChildUnsafe1,  2020/8/14
 */
public class Childsafe2 {

    public volatile static Childsafe2 childUnsafe2;
    int age;

    Childsafe2(int age){
        this.age = age;
        childUnsafe2 = this;
    }
}
