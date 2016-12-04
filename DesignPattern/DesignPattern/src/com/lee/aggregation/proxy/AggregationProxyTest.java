package com.lee.aggregation.proxy;

/**
 * 
 *聚合方式 实现的代理
 *
 */
public class AggregationProxyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoomMediation roomMediation = new RoomMediation();
		roomMediation.findHouse();
		roomMediation.callHouseOwner();
	}

}
