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
		
		System.out.println("---ÐãÒÂ·þ---");
		model.modelShow();
		
		System.out.println("---ÐãÒÂ·þ¡¢Ã±×Ó---");
		hat.modelShow();
		
		System.out.println("---ÐãÒÂ·þ¡¢ÑÛ¾µ---");
		glass.modelShow();
		
		System.out.println("---ÐãÒÂ·þ¡¢ÑÛ¾µ¡¢Ã±×Ó---");
		IModelFashionShow all = new SunglassesDecorator(hat);
		all.modelShow();
	}

}
