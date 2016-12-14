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
				//������������ʱ������wait��ͬʱ�ͷ�obj��
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
                //��ȡobj������Ȼ�����֪ͨ��֪ͨʱ�����ͷ�obj����,�����ڹ���֪ͨ
                //ֻ�е�ǰ�߳��ͷ���obj����Wait���ܴ�wait��������
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
