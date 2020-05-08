package com.flydean.closures;

import org.junit.Test;

/**
 * @author wayne
 * @version ClosureUsage,  2020/5/6 5:54 下午
 */
public class ClosureUsage {

    public Runnable createClosureUsingClass(){
        int count=10;
        Runnable runnable= new Runnable() {
            @Override
            public void run() {
                System.out.println(count);
            }
        };
        return runnable;
    }

    public Runnable createClosureUsingLambda(){
        int count=10;
        Runnable runnable=()-> System.out.println(count);
        return runnable;
    }

    @Test
    public void testClosureClass(){
       Runnable runnable= createClosureUsingClass();
        runnable.run();

    }

    @Test
    public void testClosureLambda(){
        Runnable runnable=createClosureUsingLambda();
        runnable.run();
    }




}
