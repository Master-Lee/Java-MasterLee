package com.lee.iterator;

import java.util.List;

public class ConcreteAggregate implements Aggregate {
	private List<Object> list;
	public ConcreteAggregate(List<Object> list)
	{
		this.list = list;
	}
	
	@Override
	public void add(Object obj) {
		// TODO Auto-generated method stub
		list.add(obj);
	}

	@Override
	public void remove(Object obj) {
		// TODO Auto-generated method stub
		list.remove(obj);
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new ConcreteItertor(list);
	}

}
