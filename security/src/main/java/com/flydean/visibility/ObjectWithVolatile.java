package com.flydean.visibility;

/**
 * @author wayne
 * @version ObjectWithVolatile,  2020/7/29
 */
public class ObjectWithVolatile {
    private volatile ImmutableObject refObject;
    public ImmutableObject getImmutableObject(){
        return refObject;
    }
    public void setImmutableObject(int age){
        this.refObject=new ImmutableObject(age);
    }
}
