package com.flydean.atomicity;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wayne
 * @version CompoundAtomic,  2020/7/29
 */
public class CompoundAtomic {
    private AtomicInteger atomicInteger1=new AtomicInteger(0);
    private AtomicInteger atomicInteger2=new AtomicInteger(0);

    public void update(){
        atomicInteger1.set(20);
        atomicInteger2.set(10);
    }

    public int get() {
        return atomicInteger1.get()+atomicInteger2.get();
    }
}
