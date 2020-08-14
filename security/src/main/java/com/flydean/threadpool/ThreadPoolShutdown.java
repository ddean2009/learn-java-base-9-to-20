package com.flydean.threadpool;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wayne
 * @version ThreadPoolShutdown,  2020/8/14
 */
public class ThreadPoolShutdown {

    public void wrongSubmit(){
        Runnable runnable= ()->{
            try(SocketChannel  sc = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8080))) {
            ByteBuffer buf = ByteBuffer.allocate(1024);
            while(true){
                sc.read(buf);
            }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        ExecutorService pool =  Executors.newFixedThreadPool(10);
        pool.submit(runnable);
        pool.shutdownNow();
    }

    public void correctSubmit(){
        Runnable runnable= ()->{
            try(SocketChannel  sc = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8080))) {
                ByteBuffer buf = ByteBuffer.allocate(1024);
                while(!Thread.interrupted()){
                    sc.read(buf);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        ExecutorService pool =  Executors.newFixedThreadPool(10);
        pool.submit(runnable);
        pool.shutdownNow();
    }


}
