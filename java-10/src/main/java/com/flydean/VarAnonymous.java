package com.flydean;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wayne
 * @version VarAnonymous,  2020/5/4 1:05 下午
 */

@Slf4j
public class VarAnonymous {

    @Test
    public void useAnonymousClass(){
        Runnable runnable = new Runnable() {
            String className=Thread.currentThread().getName();
            @Override
            public void run() {
                log.info("inside runnable");
            }
        };
        log.info("{}",runnable);
    }

    @Test
    public void useAnonymousVar(){
        var runnable = new Runnable() {
            String className=Thread.currentThread().getName();
            @Override
            public void run() {
                log.info("inside runnable");
            }
        };
        log.info(runnable.className);
        log.info("{}",runnable);
    }

    @Test
    public void useVarInLambda(){
       List<Object> objects=Stream.of(1,2,3,4).map(i-> new Object(){
            int count=i;
        }).filter(o -> o.count >0)
                .collect(Collectors.toList());
       log.info("{}",objects);
    }
}
