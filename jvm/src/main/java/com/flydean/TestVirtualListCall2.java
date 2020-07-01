package com.flydean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wayne
 * @version TestVirtualListCall2,  2020/6/29 10:06 下午
 */
public class TestVirtualListCall2 {

    public static void main(String[] args) throws InterruptedException {
        List<String>[] lists=new List[]{new ArrayList<>(),new LinkedList<>()};
        for (int i = 0; i < 10000; i++)
        {
            doWithVMethod(lists[i%2]);
        }
        Thread.sleep(1000);
    }

    public static void doWithVMethod(List<String> list)
    {
        list.add("www.flydean.com");
    }
}
