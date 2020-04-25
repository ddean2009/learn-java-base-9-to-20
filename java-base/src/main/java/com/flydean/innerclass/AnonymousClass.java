package com.flydean.innerclass;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author wayne
 * @version AnonymousClass,  2020/4/25 11:57 上午
 */
public class AnonymousClass {

    public static void main(String[] args) {
        SortedSet sortedSet1 = new ConcurrentSkipListSet(new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });

        SortedSet sortedSet2 = new ConcurrentSkipListSet((o1, o2) -> 0);
    }
}
