package com.flydean;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        NumberCounter numberCounter= new NumberCounter();
        Thread thread = new Thread(()->{
            while (true){
                try {
                    numberCounter.increaseNumber();
                } catch (InterruptedException e) {
                   e.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.sleep(3000);
        thread.stop();
        numberCounter.increaseNumber();
    }

}