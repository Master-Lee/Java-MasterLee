package com.lee.observer2;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcreteSubject subject = new ConcreteSubject();
		ObserverA a = new ObserverA();
		ObserverB b = new ObserverB();
		
		subject.add(a);
		subject.add(b);
		
		subject.change("I love China");
		subject.change("I love Beijing");
	}

}
