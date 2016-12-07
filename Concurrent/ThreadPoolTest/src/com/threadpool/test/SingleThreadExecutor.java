package com.threadpool.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService singleThreadExector = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++ )
		{
			final int index = i;
			singleThreadExector.execute(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(index);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			});
		}
	}

}
