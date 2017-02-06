package com.lee.clone;

public class Resume implements Cloneable {
	private String name;
	private int age;
	private WorkExperience workExp;
	
	public Resume(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public WorkExperience getWorkExp() {
		return workExp;
	}

	public void setWorkExp(WorkExperience workExp) {
		this.workExp = workExp;
	}
	
	public void display()
	{
		System.out.println("name:" + this.name);
		System.out.println("age:" + this.age);
		System.out.println("WorkExperience:");
		System.out.println("timeArea:" + workExp.getTimeArea() + " " + "company:" + workExp.getCompany());
	}
	
	@Override
	public Resume clone()
	{
		try {
			return (Resume)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
