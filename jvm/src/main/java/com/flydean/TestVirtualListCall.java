package com.flydean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wayne
 * @version TestVirtualListCall,  2020/6/29 10:06 下午
 */
public class TestVirtualListCall {

    public static void main(String[] args) throws InterruptedException {
        List<String> list=new ArrayList<>();
        for (int i = 0; i < 10000; i++)
        {
            doWithVMethod(list);
        }
        Thread.sleep(1000);
    }

    public static void doWithVMethod(List<String> list)
    {
        list.add("www.flydean.com");
    }
}
