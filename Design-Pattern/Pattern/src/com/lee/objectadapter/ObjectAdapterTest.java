package com.lee.objectadapter;


public class ObjectAdapterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyOldCellPhone myPhone = new MyOldCellPhone();
		myPhone.call();
		myPhone.text();
		System.out.println("手机变形前后");
		CellPhoneTransformer transformedPhone = new CellPhoneTransformer();
		transformedPhone.call();
		transformedPhone.text();
		transformedPhone.internet();
	}

}
