package com.lee.classloader.test;

public class ClassLoaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassLoader loader = ClassLoaderTest.class.getClassLoader();
		System.out.println(loader.toString());
		System.out.println(loader.getParent().toString());
		System.out.println(loader.getParent().getParent());
	}

}
