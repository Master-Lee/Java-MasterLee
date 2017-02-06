package com.lee.observer1;

import java.util.Observable;
import java.util.Observer;

public class ImgViewser implements Observer {
	
	public ImgViewser(DocumentContent documentContent) {
		documentContent.addObserver(this);
	}
	
	@Override
	public void update(Observable documentContent, Object conent) {
		System.out.println("ImgViewer:" + ((DocumentContent)documentContent).getData());
	}

}
