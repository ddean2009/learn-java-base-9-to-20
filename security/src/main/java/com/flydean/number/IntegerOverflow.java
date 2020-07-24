package com.flydean.number;

import org.junit.Test;

import java.math.BigInteger;

/**
 * @author wayne
 * @version IntegerOverflow,  2020/7/23
 */
public class IntegerOverflow {

    @Test
    public void testIntegerOverflow(){
        System.out.println(Integer.MAX_VALUE+1000);
        System.out.println(Integer.MAX_VALUE+1000>Integer.MAX_VALUE);
    }

    public int addUseMath(int a, int b){
        return Math.addExact(a,b);
    }

    public static long intRangeCheck(long value) {
        if ((value < Integer.MIN_VALUE) || (value > Integer.MAX_VALUE)) {
            throw new ArithmeticException("Integer overflow");
        }
        return value;
    }

    public int addUseUpcasting(int a, int b){
        return (int)intRangeCheck((long)a+(long)b);
    }

    public int useBigInteger(int a, int b){
        return BigInteger.valueOf(a).add(BigInteger.valueOf(b)).intValue();
    }
}
