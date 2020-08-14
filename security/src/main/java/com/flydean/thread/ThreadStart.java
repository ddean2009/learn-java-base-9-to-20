package com.flydean.thread;

/**
 * @author wayne
 * @version ThreadStart,  2020/8/13
 */
public class ThreadStart {

    public void wrongStart(){
        Runnable runnable= ()-> System.out.println("in thread running!");
        Thread thread= new Thread(runnable);
        thread.run();
    }

    public void correctStart(){
        Runnable runnable= ()-> System.out.println("in thread running!");
        Thread thread= new Thread(runnable);
        thread.start();
    }
}
