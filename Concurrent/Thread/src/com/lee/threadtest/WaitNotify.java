package com.lee.threadtest;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WaitNotify {
	static volatile boolean flag = true;
	static Object obj = new Object();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread waitThread = new Thread(new Wait(), "WaitThread");
		waitThread.start();
		
		try {
			TimeUnit.MICROSECONDS.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
	}

	static class Wait implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized(obj){
				//当条件不满足时，继续wait，同时释放obj锁
				while(flag)
				{
					System.out.println(Thread.currentThread().getName() + " is  waiting....." + new Date());
					try {
						obj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	static class Notify implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized(obj){
                //获取obj的锁，然后进行通知，通知时不会释放obj的锁,类似于过早通知
                //只有当前线程释放了obj锁后，Wait才能从wait方法返回
				obj.notifyAll();
				flag = false;
                System.out.println(Thread.currentThread().getName() + " is notify done...." + new Date());
                try {
					TimeUnit.MICROSECONDS.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
