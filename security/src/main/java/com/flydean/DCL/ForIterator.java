package com.flydean.DCL;

import org.junit.Test;

/**
 * @author wayne
 * @version ForIterator,  2020/7/20
 */
public class ForIterator {

    @Test
    public void noncompliantUsage(){
        int[] intArray = new int[]{1,2,3,4,5,6};
        for(int i: intArray){
            i=0;
        }
        for(int i: intArray){
            System.out.println(i);
        }
    }

    @Test
    public void compliantUsage(){
        int[] intArray = new int[]{1,2,3,4,5,6};
        for(final int i: intArray){
        }
        for(int i: intArray){
            System.out.println(i);
        }
    }
}
