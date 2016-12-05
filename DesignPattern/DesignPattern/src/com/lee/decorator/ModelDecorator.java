package com.lee.decorator;

public class ModelDecorator implements IModelFashionShow {

	protected IModelFashionShow model = null;
	
	public ModelDecorator(IModelFashionShow model)
	{
		this.model = model;
	}
	
	public void modelShow() {
		// TODO Auto-generated method stub
		model.modelShow();
	}

}
