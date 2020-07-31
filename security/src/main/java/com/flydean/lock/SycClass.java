package com.flydean.lock;

/**
 * @author wayne
 * @version SycClass,  2020/7/30
 */
public class SycClass {

    public void doSomething(){
        synchronized (getClass()){
            //do something
        }
    }
}
