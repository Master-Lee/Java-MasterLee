package com.lee.observer2;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	private List<IObserver> list = new ArrayList<IObserver>();
	
	public void add(IObserver observer)
	{
		list.add(observer);
		System.out.println("Add an observer");
	}
	
	public void delete(IObserver observer)
	{
		list.remove(observer);
	}
	
   public void nodifyObservers(String newState){
        
        for(IObserver observer : list){
        	observer.update(newState);
        }
    }
}
