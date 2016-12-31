package com.lee.iterator;

import java.util.ArrayList;
import java.util.List;

public class maintest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Object> list = new ArrayList<Object>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		Aggregate aggregate = new ConcreteAggregate(list);
		Iterator iterator = aggregate.iterator();
		
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}

}
