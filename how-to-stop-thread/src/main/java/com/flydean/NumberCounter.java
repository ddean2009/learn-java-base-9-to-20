package com.flydean;

public class NumberCounter {
    //要保存的数字
    private volatile int number=0;
    //数字计数器的逻辑是否完整
    private volatile boolean flag = false;

    public synchronized int increaseNumber() throws InterruptedException {
        if(flag){
            //逻辑不完整
            throw new RuntimeException("逻辑不完整，数字计数器未执行完毕");
        }
        //开始执行逻辑
        flag = true;
        //do something
        Thread.sleep(5000);
        number++;
        //执行完毕
        flag=false;
        return number;
    }
}
