package com.lee.observer2;

public class ObserverA implements IObserver {
	private String observerState;
	@Override
	public void update(String str) {
		// TODO Auto-generated method stub
		observerState = str;
	     System.out.println("状态为："+observerState);
	}

}
