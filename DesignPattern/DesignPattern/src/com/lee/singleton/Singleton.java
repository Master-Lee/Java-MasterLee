package com.lee.singleton;

public class Singleton {
	private static Singleton instance = null;
	private String test = "Singleton Pattern!";
	private Singleton()
	{
		
	}
	
	public static synchronized Singleton getInstance()
	{
		if (null != instance)
		{
			return instance;
		}
		else
		{
			return new Singleton();
		}
	}
	
	public void print()
	{
		System.out.print(test);
	}
}
