package com.lee.singleton;

public class SingletonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Singleton instance = Singleton.getInstance();
		
		instance.print();
	}

}
