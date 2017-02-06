package com.lee.clone;

public class WorkExperience implements Cloneable {
	private String timeArea = null;
	private String company = null;
	
	public WorkExperience(String timeArea, String company) {
		this.timeArea = timeArea;
		this.company = company;
	}

	public String getTimeArea() {
		return timeArea;
	}

	public void setTimeArea(String timeArea) {
		this.timeArea = timeArea;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}
