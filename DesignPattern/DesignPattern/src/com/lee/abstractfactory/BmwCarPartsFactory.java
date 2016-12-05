package com.lee.abstractfactory;

public class BmwCarPartsFactory implements ICarPartsFactory {

	public ICarEngine createCarEngine() {
		// TODO Auto-generated method stub
		return new BmwCarEngine();
	}

	public ICarTire createCarTire() {
		// TODO Auto-generated method stub
		return new BmwCarTire();
	}

}
