package com.flydean.number;

import org.junit.Test;

/**
 * @author wayne
 * @version TypeConvert,  2020/7/23
 */
public class TypeConvert {

    public void intToByte(int i){
        if ((i < Byte.MIN_VALUE) || (i > Byte.MAX_VALUE)) {
            throw new ArithmeticException("Value is out of range");
        }
        byte b = (byte) i;
    }

    @Test
    public void intToFloat(){
        System.out.println(subtraction(1111111111,1111111111));
    }

    public int subtraction(int i , float j){
        System.out.println(j);
        if ((j > 0x007fffff) || (j < -0x800000)) {
            throw new ArithmeticException("Insufficient precision");
        }
        return i - (int)j;
    }

    public int subtractionWithDouble(int i , double j){
        System.out.println(j);
        return i - (int)j;
    }
}
