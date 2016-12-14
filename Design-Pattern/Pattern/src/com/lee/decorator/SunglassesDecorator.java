package com.lee.decorator;

public class SunglassesDecorator extends ModelDecorator {
	public SunglassesDecorator(IModelFashionShow model)
	{
		super(model);
	}
	
	@Override
	public void modelShow()
	{
		super.modelShow();
		showSunglasses();
	}
	
	public void showSunglasses()
	{
		System.out.println("秀墨镜");
	}
}
