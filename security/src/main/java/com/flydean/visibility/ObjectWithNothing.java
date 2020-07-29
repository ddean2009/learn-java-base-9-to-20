package com.flydean.visibility;

/**
 * @author wayne
 * @version ObjectWithNothing,  2020/7/29
 */
public class ObjectWithNothing {
    private ImmutableObject refObject;
    public ImmutableObject getImmutableObject(){
        return refObject;
    }
    public void setImmutableObject(int age){
        this.refObject=new ImmutableObject(age);
    }
}
