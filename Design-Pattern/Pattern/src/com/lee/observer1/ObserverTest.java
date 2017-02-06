package com.lee.observer1;

public class ObserverTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DocumentContent doc = new DocumentContent();
		doc.setData("I love china!");
		ImgViewser imgV = new ImgViewser(doc);
		ExcelViewer exlV = new ExcelViewer(doc);
		
		doc.setData("I love ShanXi!");
		doc.setData("I love Beijing!");
	}

}
