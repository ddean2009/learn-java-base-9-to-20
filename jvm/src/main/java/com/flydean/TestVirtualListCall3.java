package com.flydean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wayne
 * @version TestVirtualListCall3,  2020/6/29 10:06 下午
 */
public class TestVirtualListCall3 {

    public static void main(String[] args) throws InterruptedException {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();
        for (int i = 0; i < 10000; i++)
        {
            doWithVMethod(list1);
        }
        Thread.sleep(1000);
        for (int i = 0; i < 10000; i++)
        {
            doWithVMethod(list2);
        }
        Thread.sleep(1000);
    }

    public static void doWithVMethod(List<String> list)
    {
        list.add("www.flydean.com");
    }
}
