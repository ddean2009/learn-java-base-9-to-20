package com.flydean.DCL;

/**
 * @author wayne
 * @version CycleClassA,  2020/7/20
 */
public class CycleClassA {
    public static final int a = CycleClassB.b+1;

    public static void main(String[] args) {
        System.out.println(CycleClassA.a);
        System.out.println(CycleClassB.b);
    }
}
