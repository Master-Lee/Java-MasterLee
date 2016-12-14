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
		
		System.out.println("---秀衣服---");
		model.modelShow();
		
		System.out.println("---秀衣服、帽子---");
		hat.modelShow();
		
		System.out.println("---秀衣服、眼镜---");
		glass.modelShow();
		
		System.out.println("---秀衣服、眼镜、帽子---");
		IModelFashionShow all = new SunglassesDecorator(hat);
		all.modelShow();
	}

}
