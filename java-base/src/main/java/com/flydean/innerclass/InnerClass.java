package com.flydean.innerclass;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wayne
 * @version InnerClass,  2020/4/25 11:30 上午
 */
@Slf4j
public class InnerClass {

     class Inner {
        void print() {
            log.info("Inner class is: " + this);
        }
    }

    public static void main(String[] args) {
        InnerClass.Inner inner = new InnerClass().new Inner();
        inner.print();
    }
}
