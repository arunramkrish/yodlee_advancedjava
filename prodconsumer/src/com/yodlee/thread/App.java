package com.yodlee.thread;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {

	public static void main(String[] args) {
		ExecutorService executors = Executors.newFixedThreadPool(1);
		BlockingQueue<Product> productsBuffer = new ArrayBlockingQueue<>(10);

		Producer producer = new Producer(productsBuffer);
		Consumer consumer = new Consumer(productsBuffer);

		executors.submit(producer);
		Future<Long> future = executors.submit(consumer);
		do {
			System.out
					.print("Enter no. of products to create or enter 'quit' to exit");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();

			if ("quit".equalsIgnoreCase(input)) {
				producer.shutdown();

				if (future.isDone()) {
					consumer.shutdown();
				}

				try {
					System.out.println("Id from consumer" + future.get());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				executors.shutdown();
				System.exit(1);
			}

			producer.produce(Integer.parseInt(input));
		} while (true);

	}

}
