package com.yodlee.thread;

import java.util.Date;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private BlockingQueue<Product> productsBuffer;
	private Integer producsCounter = 0;
	private boolean isRunning = true;
	
	public Producer(BlockingQueue<Product> productsBuffer) {
		this.productsBuffer = productsBuffer;
	}
	
	@Override
	public void run() {
		while (isRunning ) {
//			System.out.println(producsCounter);
			while (producsCounter > 0) {
				Product prod = new Product("prod " + producsCounter, producsCounter, new Date());
				System.out.println("producing " + prod);
				productsBuffer.add(prod);
				producsCounter--;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown() {
		isRunning = false;
	}
	
	public void produce(int quantity) {
		producsCounter += quantity;
	}

}
