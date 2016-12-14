package com.lee.abstractfactory;

public class BenzCarPartsFactory implements ICarPartsFactory {

	public ICarEngine createCarEngine() {
		// TODO Auto-generated method stub
		return new BenzCarEngine();
	}

	public ICarTire createCarTire() {
		// TODO Auto-generated method stub
		return new BenzCarTire();
	}

}
