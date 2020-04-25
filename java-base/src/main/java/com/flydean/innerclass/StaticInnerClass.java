package com.flydean.innerclass;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 * @version StaticInnerClass,  2020/4/25 11:30 上午
 */
@Slf4j
public class StaticInnerClass {

    static class Inner {
        void print() {
            log.info("Inner class is: " + this);
        }
    }

    public static void main(String[] args) {
        StaticInnerClass.Inner inner = new StaticInnerClass.Inner();
        inner.print();
    }
}
