package com.flydean.lock;

/**
 * @author wayne
 * @version SynObject,  2020/7/29
 */
public class SynObject {

    public synchronized  void doSomething(){
        //do something
    }

    public Object lock = new Object();

    public void doSomething2(){
        synchronized (lock){
            //do something
        }
    }

    private volatile Object lock2 = new Object();

    public void doSomething3() {
        synchronized (lock2) {
            // do something
        }
    }

    public void setLock2(Object lockValue) {
        lock2 = lockValue;
    }

    private final Object lock4= new Object();

    public void doSomething4() {
        synchronized (lock4) {
            // do something
        }
    }

    public static synchronized void doSomething5() {
        // do something
    }

    public static void main(String[] args) throws InterruptedException {
        SynObject synObject= new SynObject();
        synchronized (synObject){
            while (true){
                //loop forever
                Thread.sleep(10000);
            }
        }

    }
}
