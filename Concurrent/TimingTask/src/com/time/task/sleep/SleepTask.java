package com.time.task.sleep;

public class SleepTask {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final long timeInterval = 1000;   //1s Ö´ÐÐÒ»´Î
		Runnable runnable = new Runnable(){
			public void run()
			{
				while(true){
					System.out.println("Hello !!");
				
					try {
						Thread.sleep(timeInterval);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread thread = new Thread(runnable);
		Thread thread2 = new Thread(){
			public void run()
			{
				while(true){
					System.out.println("World !!");
				
					try {
						Thread.sleep(timeInterval);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		thread.start();
		thread2.start();
	}
}
