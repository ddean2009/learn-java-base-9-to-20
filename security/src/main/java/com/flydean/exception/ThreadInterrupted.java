package com.flydean.exception;

/**
 * @author wayne
 * @version ThreadInterrupted,  2020/7/28
 */
public class ThreadInterrupted {

    public void wrongInterrupted(){
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void correctInterrupted(){
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
