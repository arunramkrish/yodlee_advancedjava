package com.yodlee.threadpool;

import java.util.concurrent.CountDownLatch;

public class Waiter implements Runnable{

    CountDownLatch latch = null;

    public Waiter(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
        	System.out.println("Latching wait");
            latch.await();
            System.out.println("Latching after await");
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Waiter Released");
    }
}
