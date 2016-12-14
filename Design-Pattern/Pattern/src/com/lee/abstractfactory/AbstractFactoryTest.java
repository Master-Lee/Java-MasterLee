package com.lee.abstractfactory;

public class AbstractFactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ICarPartsFactory benzFactory = new BenzCarPartsFactory();
		ICarEngine benzEngine = benzFactory.createCarEngine();
		ICarTire benzTire = benzFactory.createCarTire();
	}

}
