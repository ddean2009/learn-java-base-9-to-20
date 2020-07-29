package com.flydean.exception;

/**
 * @author wayne
 * @version FinallyUsage,  2020/7/28
 */
public class FinallyUsage {

    public boolean wrongFinally(){
        try{
            throw new IllegalStateException("my exception!");
        }finally {
            System.out.println("Code comes to here!");
            return true;
        }
    }

    public boolean rightFinally(){
        try{
            throw new IllegalStateException("my exception!");
        }finally {
            System.out.println("Code comes to here!");
        }
    }

    public static void main(String[] args) {
        FinallyUsage finallyUsage=new FinallyUsage();
        finallyUsage.wrongFinally();
        finallyUsage.rightFinally();
    }
}
