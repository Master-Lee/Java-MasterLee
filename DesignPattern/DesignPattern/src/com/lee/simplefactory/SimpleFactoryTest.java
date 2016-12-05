package com.lee.simplefactory;

public class SimpleFactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ICar benz = CarFactory.createCar("Benz");
		benz.run();
		
		ICar bmw = CarFactory.createCar("Bmw");
		bmw.run();
	}

}
