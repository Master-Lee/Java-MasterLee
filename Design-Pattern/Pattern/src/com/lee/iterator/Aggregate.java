package com.lee.iterator;

public interface Aggregate {
	public void add(Object obj);
	public void remove(Object obj);
	public Iterator iterator();
}
