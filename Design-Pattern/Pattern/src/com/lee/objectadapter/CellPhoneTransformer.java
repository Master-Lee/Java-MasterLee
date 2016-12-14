package com.lee.objectadapter;

import com.lee.classadapter.ILatestCellPhone;
/**
 * 
 * 对象适配器
 *
 */
public class CellPhoneTransformer implements ILatestCellPhone {

	MyOldCellPhone myOldPhone = new MyOldCellPhone();
	MyOldCellPhoneSon myOldPhoneSon = new MyOldCellPhoneSon();
	
	public void call() {
		// TODO Auto-generated method stub
		myOldPhone.call();
	}

	public void text() {
		// TODO Auto-generated method stub
//		myOldPhone.text();
		myOldPhoneSon.text();
	}

	public void internet() {
		// TODO Auto-generated method stub
		System.out.println("Latest CellPhone internet");
	}

}
