package com.flydean.thread;

/**
 * @author wayne
 * @version ThreadStop,  2020/8/13
 */
public class ThreadStop {
    private volatile boolean done = false;

    public void shutDown(){
        this.done= true;
    }

    public void stopWithFlag(){

        Runnable runnable= ()->{
            while(!done){
                System.out.println("in Runnable");
            }
        };

        Thread thread= new Thread(runnable);
        thread.start();
        shutDown();
    }


}
