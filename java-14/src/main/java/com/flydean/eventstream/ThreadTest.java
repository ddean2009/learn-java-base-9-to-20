package com.flydean.eventstream;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wayne
 * @version ThreadTest,  2020/4/29 9:27 上午
 */
@Slf4j
public class ThreadTest {

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        Runnable runnable= ()->{
            while(true){
                log.info(Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    log.error(e.getMessage(),e);
                }
            }
        };

        for(int i=0; i<10; i++){
            executorService.submit(runnable);
        }
    }
}
