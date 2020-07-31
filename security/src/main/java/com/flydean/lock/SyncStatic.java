package com.flydean.lock;

/**
 * @author wayne
 * @version SyncStatic,  2020/7/30
 */
public class SyncStatic {
    private static volatile int age;

    public synchronized void doSomething(){
        age++;
    }

    private final Object lock = new Object();
    public  void doSomething2(){
        synchronized (lock) {
            age++;
        }
    }

    private static final Object lock3 = new Object();
    public  void doSomething3(){
        synchronized (lock3) {
            age++;
        }
    }
}
