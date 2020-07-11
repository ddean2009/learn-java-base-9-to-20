package com.flydean;

/**
 * @author wayne
 * @version TestLoop,  2020/7/4 10:14 上午
 */
public class TestDeadLock {
    public static Object lock1= new Object();
    public static Object lock2= new Object();
    public static void main(String[] args) {
        Runnable runnable1= ()-> {
            System.out.println("in lock1");
            synchronized(lock1){
                System.out.println("Lock1 lock obj1");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(lock2){
                    System.out.println("Lock1 lock obj2");
                }
            }
        };

        Runnable runnable2= ()-> {
            System.out.println("in lock2");
            synchronized(lock2){
                System.out.println("Lock2 lock obj2");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(lock1){
                    System.out.println("Lock2 lock obj1");
                }
            }
        };

        Thread a = new Thread(runnable1);
        Thread b = new Thread(runnable2);
        a.start();
        b.start();
    }
}
