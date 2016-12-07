package com.time.task.scheduledesxecutorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTask {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Runnable runnable = new Runnable(){

			public void run() {
				System.out.println("Hello!!");
			}
			
		};
		
		ScheduledExecutorService service = Executors
				.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS);
	}
}
