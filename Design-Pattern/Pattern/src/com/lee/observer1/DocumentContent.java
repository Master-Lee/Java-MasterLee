package com.lee.observer1;

import java.util.Observable;

public class DocumentContent extends Observable {
	private String documentContent = "";
	
	public String getData()
	{
		return documentContent;
	}
	
	public void setData(String document)
	{
		if (!this.documentContent.equals(document))
		{
			this.documentContent = document;
			setChanged();
			notifyObservers();
		}
	}
}
