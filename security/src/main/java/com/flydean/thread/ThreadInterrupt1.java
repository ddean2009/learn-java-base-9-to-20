package com.flydean.thread;

/**
 * @author wayne
 * @version ThreadInterrupt,  2020/8/13
 */
public class ThreadInterrupt1 {

    public static void main(String[] args)  {
        Runnable runnable= ()->{
            while (!Thread.interrupted()) {
             System.out.println("in thread");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread= new Thread(runnable);
        thread.start();
        thread.interrupt();
    }
}
