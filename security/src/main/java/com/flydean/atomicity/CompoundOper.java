package com.flydean.atomicity;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wayne
 * @version CompoundOper1,  2020/7/29
 */
public class CompoundOper {
    private int i=0;
    public int increase(){
        i++;
        return i;
    }

    public synchronized int increaseSync(){
        i++;
        return i;
    }

    private final ReentrantLock reentrantLock=new ReentrantLock();

    public int increaseWithLock(){
        try{
            reentrantLock.lock();
            i++;
            return i;
        }finally {
            reentrantLock.unlock();
        }
    }

    private AtomicInteger atomicInteger=new AtomicInteger(0);

    public int increaseWithAtomic(){
        return atomicInteger.incrementAndGet();
    }
}
