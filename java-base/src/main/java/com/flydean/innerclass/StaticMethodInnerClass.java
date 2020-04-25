package com.flydean.innerclass;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 * @version StaticMethodInnerClass,  2020/4/25 11:47 上午
 */
@Slf4j
public class StaticMethodInnerClass {

    private static String x = "static x";

    public static void print() {
        class MyInner {
            public void printOuter() {
                log.info("x is " + x);
            }
        }
        MyInner i = new MyInner();
        i.printOuter();
    }

    public static void main(String[] args) {
        StaticMethodInnerClass.print();
    }
}
