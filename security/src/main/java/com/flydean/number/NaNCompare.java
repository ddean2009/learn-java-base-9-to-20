package com.flydean.number;

import org.junit.Test;

/**
 * @author wayne
 * @version NaNCompare,  2020/7/23
 */
public class NaNCompare {

    @Test
    public void compareInfinity(){
    System.out.println(Double.POSITIVE_INFINITY == Double.POSITIVE_INFINITY);
    }

    @Test
    public void compareNaN(){
        System.out.println(Double.NaN == Double.NaN);
        System.out.println(Double.isNaN(Double.NaN));

    }

    @Test
    public void testNaN(){
        System.out.println(Double.valueOf("NaN"));
        System.out.println(Double.valueOf("Infinity"));
        System.out.println(Double.valueOf("-Infinity"));
    }


    public void incorrectParse(String userInput){
        double val = 0;
        try {
            val = Double.valueOf(userInput);
        } catch (NumberFormatException e) {
        }
        //do something for val
    }

    //userInput can be Infinity or NaN
    public void correctParse(String userInput){
        double val = 0;
        try {
            val = Double.valueOf(userInput);
        } catch (NumberFormatException e) {
        }
        if (Double.isInfinite(val)){
            // Handle infinity error
        }

        if (Double.isNaN(val)) {
            // Handle NaN error
        }
        //do something for val
    }

}
