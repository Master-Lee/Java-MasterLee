package com.lee.decorator;

public class HatDecorator extends ModelDecorator {
	public HatDecorator(IModelFashionShow model)
	{
		super(model);
	}
	
	@Override
	public void modelShow()
	{
		super.modelShow();
		showHat();
	}
	
	public void showHat()
	{
		System.out.println("ÐãÃ±×Ó");
	}
}
