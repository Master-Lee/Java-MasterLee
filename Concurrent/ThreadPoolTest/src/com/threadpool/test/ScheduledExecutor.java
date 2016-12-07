package com.threadpool.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScheduledExecutorService scheduledThreadPool
			= Executors.newScheduledThreadPool(5);
		
		scheduledThreadPool.scheduleAtFixedRate(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("delay 1 seconds, and excute every 3 seconds");
			}
			
		}, 1, 3, TimeUnit.SECONDS);
	}

}
