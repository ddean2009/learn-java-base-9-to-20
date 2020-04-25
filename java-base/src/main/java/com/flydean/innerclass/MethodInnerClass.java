package com.flydean.innerclass;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 * @version MethodInnerClass,  2020/4/25 11:47 上午
 */
@Slf4j
public class MethodInnerClass {

    private  String x = "non static x";

    public  void print() {
        class MyInner {
            public void printOuter() {
                log.info("x is " + x);
            }
        }
        MyInner i = new MyInner();
        i.printOuter();
    }

    public static void main(String[] args) {
        new MethodInnerClass().print();
    }
}
