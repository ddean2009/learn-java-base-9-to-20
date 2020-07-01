package com.flydean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wayne
 * @version TestNull,  2020/7/1
 */
public class TestNull2 {

    public static void main(String[] args) throws InterruptedException {
        List<String> list= new ArrayList();
        list.add("www.flydean.com");
        for (int i = 0; i < 10000; i++)
        {
            testMethod(list);
        }
        Thread.sleep(1000);
        testMethod(null);
        for (int i = 0; i < 10000; i++)
        {
            testMethod(list);
        }
        Thread.sleep(1000);
    }

    private static void testMethod(List<String> list)
    {
        if(list !=null ){
            list.get(0);
        }
    }
}
