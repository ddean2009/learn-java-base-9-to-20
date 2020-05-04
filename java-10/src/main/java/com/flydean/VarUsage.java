package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wayne
 * @version VarUsage,  2020/5/4 9:47 上午
 */
@Slf4j
public class VarUsage {

    public void oldUsage(){
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                log.info("inside runnable");
            }
        };
        executorService.submit(runnable);
    }

    public void useVar(){
        var executorService= Executors.newSingleThreadExecutor();
        var runnable=new Runnable() {
            @Override
            public void run() {
                log.info("inside runnable");
            }
        };
        executorService.submit(runnable);
    }

    public void useLongName(){
        ItIsAVeryLongNameJavaClass itIsAVeryLongNameJavaClass= new ItIsAVeryLongNameJavaClass();
    }

    public void unableToInfer(){
//        var ints = {1, 2, 3};
//        var lambda = a -> a;
//        var methodReference = String::concat;
    }


}
