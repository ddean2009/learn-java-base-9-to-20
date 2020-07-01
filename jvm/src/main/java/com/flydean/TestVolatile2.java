package com.flydean;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wayne
 * @version TestVolatile,  2020/6/30
 */
public class TestVolatile2 {

    private static int int1;
    private static AtomicInteger int2=new AtomicInteger(0);
    private static int int3;
    private static int int4;
    private static int int5;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++)
        {
            increase(i);
        }
        Thread.sleep(1000);
    }

    private static void increase(int i){
        int1= i+1;
        int2.lazySet(i+2);
        int3= i+3;
        int4= i+4;
        int5= i+5;
    }
}
