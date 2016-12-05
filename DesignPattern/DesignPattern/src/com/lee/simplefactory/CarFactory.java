package com.lee.simplefactory;

public class CarFactory {
	public static ICar createCar(String carName)
	{
		if ("Benz".equals(carName))
		{
			return new BenzCar();
		}
		
		if ("Bmw".equals(carName))
		{
			return new BmwCar();
		}
		
		return null;
	}
}
