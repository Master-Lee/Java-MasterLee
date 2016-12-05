package com.lee.templetemethod;

public abstract class PptTemplate {
	public void showPpt()
	{
		showBackground();
		showAuthorName();
		showTheme();
	}
	
	public void showBackground()
	{
		System.out.println("�׵����߱���");
	}
	
	public abstract void showTheme();
	
	public abstract void showAuthorName();
}
