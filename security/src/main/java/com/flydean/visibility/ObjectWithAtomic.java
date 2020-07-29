package com.flydean.visibility;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wayne
 * @version ObjectWithAtomic,  2020/7/29
 */
public class ObjectWithAtomic {
    private final AtomicReference<ImmutableObject> refObject= new AtomicReference<>();
    public ImmutableObject getImmutableObject(){
        return refObject.get();
    }
    public void setImmutableObject(int age){
        refObject.set(new ImmutableObject(age));
    }
}
