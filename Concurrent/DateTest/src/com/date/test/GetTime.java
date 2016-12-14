package com.date.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTime {

	//��ȡʱ���
	public static void getTimeStamp(){
		Date date = new Date();
		long times = date.getTime();
		System.out.println(times);
	}
	
	//��ȡ��ʽ����ʱ��
	public static void getFormateDate()
	{
		Date date = new Date();
		long times = date.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(date);
		System.out.println(date);
		System.out.println(dateString);
	}
	
	public static void timestampToDate()
	{
		long times = System.currentTimeMillis();
		Date date = new Date(times);
		System.out.println(date);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		getTimeStamp();
		getFormateDate();
		timestampToDate();
	}

}