package com.flydean.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wayne
 * @version SyncLock,  2020/7/30
 */
public class SyncLock {

    private final Lock lock = new ReentrantLock();

    public void doSomething(){
        synchronized (lock){
            //do something
        }
    }

    public void doSomething2(){
        lock.lock();
        try{
        //do something
        }finally {
            lock.unlock();
        }
    }
}
