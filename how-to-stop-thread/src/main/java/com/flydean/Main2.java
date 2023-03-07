package com.flydean;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        NumberCounter numberCounter = new NumberCounter();

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    numberCounter.increaseNumber();
                } catch (InterruptedException e) {
                    System.out.println("捕获InterruptedException");
                    throw new RuntimeException(e);
                }
            }
        });

        thread.start();
        Thread.sleep(500);
        thread.interrupt();
        numberCounter.increaseNumber();
    }

}