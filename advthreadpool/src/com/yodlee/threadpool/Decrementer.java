package com.yodlee.threadpool;

import java.util.concurrent.CountDownLatch;

public class Decrementer implements Runnable {

    CountDownLatch latch = null;

    public Decrementer(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {

        try {
            Thread.sleep(1000);
            System.out.println("Latching 1");
            this.latch.countDown();

            Thread.sleep(1000);
            System.out.println("Latching 2");
            this.latch.countDown();

            Thread.sleep(1000);
            System.out.println("Latching 3");
            this.latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

