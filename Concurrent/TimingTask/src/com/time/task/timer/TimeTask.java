package com.time.task.timer;
import java.util.Timer;
import java.util.TimerTask;
public class TimeTask {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TimerTask task = new TimerTask(){
			public void run()
			{
				System.out.println("Hello !!!");
			}
		};
		
		Timer timer = new Timer();
		long delay = 0;
		long intevalPeriod = 1 * 1000;
		
		timer.scheduleAtFixedRate(task, delay, intevalPeriod);
	}

}
