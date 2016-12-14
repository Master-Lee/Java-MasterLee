package com.lee.queuetest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ConsumerProducer {
	//������
	static class Consumer implements Runnable{
		private BlockingQueue blockingQueue;
		
		public Consumer(BlockingQueue queue)
		{
			this.blockingQueue = queue;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true)
			{
				//����ʽ����
				try {
					Object val = blockingQueue.take();
					System.out.println("������Ϣ�� " + val);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//������
	static class Producer implements Runnable{
		private final BlockingQueue blockingQueue;
		
		public Producer(BlockingQueue queue)
		{
			this.blockingQueue = queue;
		}
		
		public void run()
		{
			for (int i = 0; i < 100; i++){
				try {
					blockingQueue.put(i + ":message");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("������Ϣ�� " + i);
			}
		}
	}
	
	public static void main(String[] args)
	{
		BlockingQueue queue = new LinkedBlockingDeque();
		Consumer consumer = new Consumer(queue);
		Producer producer = new Producer(queue);
		
		new Thread(producer).start();
		new Thread(consumer).start();
	}
}
