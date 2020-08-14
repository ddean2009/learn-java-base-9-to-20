package com.flydean.threadpool;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author wayne
 * @version ThreadPoolException,  2020/8/14
 */
public class ThreadPoolException {

    @Test
    public void wrongSubmit() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        Runnable runnable= ()->{
            throw new NullPointerException();
        };
        pool.execute(runnable);
        Thread.sleep(5000);
        System.out.println("finished!");
    }

    public void useFuture() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        Runnable runnable= ()->{
            throw new NullPointerException();
        };
        Future future = pool.submit(runnable);
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Thread.sleep(5000);
        System.out.println("finished!");
    }

    public void useExceptionHandler() throws InterruptedException {
        ThreadFactory factory =
                new ExceptionThreadFactory(new MyExceptionHandler());
        ExecutorService pool =
                Executors.newFixedThreadPool(10, factory);
        Runnable runnable= ()->{
            throw new NullPointerException();
        };
        pool.execute(runnable);
        Thread.sleep(5000);
        System.out.println("finished!");
    }

    public static class ExceptionThreadFactory implements ThreadFactory {
        private static final ThreadFactory defaultFactory =
                Executors.defaultThreadFactory();
        private final Thread.UncaughtExceptionHandler handler;

        public ExceptionThreadFactory(
                Thread.UncaughtExceptionHandler handler)
        {
            this.handler = handler;
        }

        @Override
        public Thread newThread(Runnable run) {
            Thread thread = defaultFactory.newThread(run);
            thread.setUncaughtExceptionHandler(handler);
            return thread;
        }
    }

    public static class MyExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {

        }
    }


}
