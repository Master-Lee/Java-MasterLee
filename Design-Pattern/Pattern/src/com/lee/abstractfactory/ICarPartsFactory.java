package com.lee.abstractfactory;

public interface ICarPartsFactory {
	public ICarEngine createCarEngine();
	public ICarTire createCarTire();
}
