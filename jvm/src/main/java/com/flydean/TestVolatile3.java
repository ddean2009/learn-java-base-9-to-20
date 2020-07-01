package com.flydean;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wayne
 * @version TestVolatile,  2020/6/30
 */
public class TestVolatile3 {

    private static volatile int int1=10;
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++)
        {
            readInt(i);
        }
        Thread.sleep(1000);
    }

    private static void readInt(int i){
        if(int1 < 5){
            System.out.println(i);
        }
    }
}
