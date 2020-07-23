package com.flydean.DCL;

/**
 * @author wayne
 * @version StaticFiledOrder,  2020/7/20
 */
public class StaticFiledOrder {
    private final int result;
    private static final StaticFiledOrder instance = new StaticFiledOrder();
//    private static final int intValue=100;
    private static final int intValue=(int)Math.random()* 1000;
    public StaticFiledOrder(){
        result= intValue - 10;
    }

    public static void main(String[] args) {
        System.out.println(instance.result);
    }
}
