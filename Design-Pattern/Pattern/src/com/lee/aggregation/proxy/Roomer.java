package com.lee.aggregation.proxy;

//房客
public class Roomer implements IRentHouse {

	public void findHouse() {
		// TODO Auto-generated method stub
		System.out.println("找房子");
	}

	public void callHouseOwner() {
		// TODO Auto-generated method stub
		System.out.println("联系房东");
	}

}
