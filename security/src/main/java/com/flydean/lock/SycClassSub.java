package com.flydean.lock;

/**
 * @author wayne
 * @version SycClassSub,  2020/7/30
 */
public class SycClassSub extends SycClass{

    public void doSomethingElse(){
        synchronized (SycClass.class){
           doSomething();
        }
    }
}
