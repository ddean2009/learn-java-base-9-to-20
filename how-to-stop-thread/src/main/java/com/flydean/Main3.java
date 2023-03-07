package com.flydean;

public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        NumberCounter numberCounter = new NumberCounter();

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    numberCounter.increaseNumber();
                } catch (InterruptedException e) {
                    System.out.println("捕获InterruptedException");
                    Thread.currentThread().interrupt();
                }
            }
        });

        thread.start();
        Thread.sleep(500);
        thread.interrupt();
        numberCounter.increaseNumber();
    }

}