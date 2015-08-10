package com.yodlee.thread;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class Consumer implements Callable<Long>{
	private PrintStream fileWriter;
	private boolean isRunning = true;
	private BlockingQueue<Product> productsBuffer;
	
	public Consumer(BlockingQueue<Product> productsBuffer) {
		this.productsBuffer = productsBuffer;
		try {
			fileWriter = new PrintStream("e:/products.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void shutdown() {
		isRunning = false;
		fileWriter.close();
	}
	@Override
	public Long call() throws Exception {
		long lastWrittenProduct = -1;
		do {
			while(!productsBuffer.isEmpty()) {
				Product prod = productsBuffer.take();
				System.out.println("Consuming " + prod);
				lastWrittenProduct = prod.getId();
				
				fileWriter.println(prod);
			}
		} while(isRunning);
		return lastWrittenProduct;
	}

}
