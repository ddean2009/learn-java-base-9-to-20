package com.flydean.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wayne
 * @version CustomThreadPoolExecutor,  2020/8/14
 */
public class CustomThreadPoolExecutor extends ThreadPoolExecutor {
    public CustomThreadPoolExecutor(
            int corePoolSize, int maximumPoolSize, long keepAliveTime,
            TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }


    @Override
    public void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if (t != null) {
            // Exception occurred, forward to handler
        }
        // ... Perform task-specific cleanup actions
    }

    @Override
    public void terminated() {
        super.terminated();
        // ... Perform final clean-up actions
    }
}
