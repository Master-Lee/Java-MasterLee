package com.lee.inherit.proxy;

/**
 * 
 *继承方式 实现的代理
 *
 */

public class InheritProxyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoomMediation2 roomMediation = new RoomMediation2();
		roomMediation.findHouse();
		roomMediation.callHouseOwner();
	}

}
