package com.lee.classadapter;

/**
 * 
 * 类适配器
 *
 */
public class CellPhoneTransformer extends OldCellPhone implements
		ILatestCellPhone {

	@Override
	public void text()
	{
		System.out.println("OldCellPhone text!");
		System.out.println("OldCellPhone text multimedia message!");
	}
	
	public void internet() {
		// TODO Auto-generated method stub
		System.out.println("Latest CellPhone internet");
	}
}
