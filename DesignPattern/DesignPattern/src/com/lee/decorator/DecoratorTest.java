package com.lee.decorator;

public class DecoratorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IModelFashionShow model = new Model();
		IModelFashionShow hat = new HatDecorator(model);
		IModelFashionShow glass = new SunglassesDecorator(model);
		
		System.out.println("---���·�---");
		model.modelShow();
		
		System.out.println("---���·���ñ��---");
		hat.modelShow();
		
		System.out.println("---���·����۾�---");
		glass.modelShow();
		
		System.out.println("---���·����۾���ñ��---");
		IModelFashionShow all = new SunglassesDecorator(hat);
		all.modelShow();
	}

}
