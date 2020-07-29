package com.flydean.visibility;

/**
 * @author wayne
 * @version ObjectWithSync,  2020/7/29
 */
public class ObjectWithSync {
    private  ImmutableObject refObject;
    public synchronized ImmutableObject getImmutableObject(){
        return refObject;
    }
    public synchronized void setImmutableObject(int age){
        this.refObject=new ImmutableObject(age);
    }
}
