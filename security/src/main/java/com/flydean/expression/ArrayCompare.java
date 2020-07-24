package com.flydean.expression;

import java.util.Arrays;

/**
 * @author wayne
 * @version ArrayCompare,  2020/7/23
 */
public class ArrayCompare {

    public boolean compareWrong(){
        int[] array1 = new int[10];
        int[] array2 = new int[10];
        return array1.equals(array2);
    }

    public boolean compareRight(){
        int[] array1 = new int[10];
        int[] array2 = new int[10];
        return Arrays.equals(array1, array2);
    }
}
