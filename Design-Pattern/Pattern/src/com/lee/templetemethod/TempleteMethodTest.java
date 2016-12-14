package com.lee.templetemethod;

public class TempleteMethodTest {
	public static void main(String[] args)
	{
		PptTemplate jim = new PptOfJim();
		PptTemplate lucy = new PptOfLucy();
		
		jim.showPpt();
		lucy.showPpt();
	}
}
