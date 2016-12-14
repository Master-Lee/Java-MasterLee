package com.lee.task;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class CallableFuture {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建一个缓冲线程池
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		//创建一个Task，实现了Callable接口
		Task task = new Task();
		
		Future<Integer> future = executorService.submit(task);
		
		try {
			System.out.println("主线程在执行任务");
			Integer result = future.get();
			System.out.println("task execute result is : " + result);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static class Task implements Callable<Integer>
	{

		@Override
		public Integer call() throws Exception {
			// TODO Auto-generated method stub
			System.out.println("任务线程在进行计算");
			int sum = 0;
			for (int i = 0; i < 100; i++)
			{
				sum += i;
			}
			return sum;
		}
	}

}
