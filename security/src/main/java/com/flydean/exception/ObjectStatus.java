package com.flydean.exception;

/**
 * @author wayne
 * @version ObjectStatus,  2020/7/28
 */
public class ObjectStatus {

    private int age=30;

    public void wrongRestore(){
        try{
            age=20;
            throw new IllegalStateException("custom exception!");
        }catch (IllegalStateException e){
            System.out.println("we do nothing");
        }
    }

    public void rightRestore(){
        try{
            age=20;
            throw new IllegalStateException("custom exception!");
        }catch (IllegalStateException e){
            System.out.println("we do nothing");
            age=30;
        }
    }
}
