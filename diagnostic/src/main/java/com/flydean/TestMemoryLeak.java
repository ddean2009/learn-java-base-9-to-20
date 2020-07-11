package com.flydean;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author wayne
 * @version TestMemoryLeak,  2020/7/4 12:28 下午
 */
public class TestMemoryLeak {

    public static HashSet<Object> hashSet= new HashSet();

    public static void main(String[] args) throws InterruptedException {
        boolean flag= true;
        while(flag){
            KeyObject keyObject= new KeyObject();
            hashSet.add(keyObject);
            keyObject=null;
            Thread.sleep(1);
        }
        System.out.println(hashSet.remove(new KeyObject()));

    }
}
