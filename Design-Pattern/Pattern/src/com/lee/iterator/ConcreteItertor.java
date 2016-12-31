package com.lee.iterator;

import java.util.List;

public class ConcreteItertor implements Iterator {
	private List<Object> list;
	private int cursor = 0;
	
	public ConcreteItertor(List<Object> list)
	{
		this.list = list;
	}
	
	@Override
	public Object next() {
		// TODO Auto-generated method stub
		Object obj = null;
		if (hasNext())
		{
			obj = list.get(cursor++);
		}
		return obj;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return !(cursor == list.size());
	}

}
