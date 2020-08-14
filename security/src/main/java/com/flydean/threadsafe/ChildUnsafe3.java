package com.flydean.threadsafe;

/**
 * @author wayne
 * @version ChildUnsafe1,  2020/8/14
 */
public class ChildUnsafe3 extends Childsafe2{

    private Object obj;

    ChildUnsafe3(int age){
       super(10);
       obj= new Object();
    }

    public void doSomething(){
        System.out.println(obj.toString());
    }
}
