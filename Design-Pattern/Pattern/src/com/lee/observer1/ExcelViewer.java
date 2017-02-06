package com.lee.observer1;

import java.util.Observable;
import java.util.Observer;

public class ExcelViewer implements Observer {
	
	public ExcelViewer(DocumentContent documentContent) {
		documentContent.addObserver(this);
	}
	@Override
	public void update(Observable documentContent, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("ExcelViewer:" + ((DocumentContent)documentContent).getData());
	}

}
