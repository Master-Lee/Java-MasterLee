package com.time.task.everydaytask;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EveryDayTask {
	
	static int count = 0;
	
	public static void showTimer(){
		TimerTask task = new TimerTask(){

			public void run() {
				++count;
				System.out.println("ʱ��=" + new Date(System.currentTimeMillis()) + "ִ����" + count + "��");
			}
		};
		
		//����ִ��ʱ��
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH); //ÿ��
		
		//����ÿ��21:09:00ִ��
		calendar.set(year, month, day, 21, 52, 00);
		
		Date date = calendar.getTime();
		Timer timer = new Timer();
//		System.out.println(date);
		
		int period = 2 * 1000;
		//ÿ���dateʱ��ִ��task��ÿ��2���ظ�ִ��
		timer.schedule(task, date, period);
		
		//ÿ���dateʱ��ִ��task����ִ��һ��
		//timer.schedule(task,date);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		showTimer();
	}

}
