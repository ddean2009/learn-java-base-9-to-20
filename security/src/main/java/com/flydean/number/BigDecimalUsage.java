package com.flydean.number;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author wayne
 * @version BigDecimalUsage,  2020/7/23
 */
public class BigDecimalUsage {

    @Test
    public void getFromFloat(){
        System.out.println(new BigDecimal(0.1));
    }

    @Test
    public void getFromString(){
        System.out.println(new BigDecimal("0.1"));
    }

    @Test
    public void valueOf(){
        System.out.println(Double.valueOf(1 / 1000.0));
        System.out.println(Double.valueOf(1 / 10000.0));
    }
}
