package com.lee.xian;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThread implements Runnable {
	public static void main(String[] args)
	{
		ThreadFactory threadFactory = new ThreadFactory(){
			private AtomicInteger count = new AtomicInteger();
			@Override
			public Thread newThread(Runnable r) {
				int c = count.incrementAndGet();
				System.out.println("create no " + c + " Threads");
				return new WorkThread(r,count);
			}
			
		};
		
		ExecutorService ctp = Executors.newCachedThreadPool(threadFactory);
		
		ctp.execute(new MyThread());
		ctp.execute(new MyThread());
		ctp.execute(new MyThread());
		ctp.execute(new MyThread());
		ctp.execute(new MyThread());
		
		ctp.shutdown();
			try {
				ctp.awaitTermination(1200, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	@Override
	public void run() {
		System.out.println("complete a task!!!");
	}

}
