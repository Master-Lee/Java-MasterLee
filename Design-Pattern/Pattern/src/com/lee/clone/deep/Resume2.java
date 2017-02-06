package com.lee.clone.deep;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Resume2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1637623756409674771L;
	private String name;
	private int age;
	private WorkExperience2 workExp;
	
	Resume2(String name, int age)
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

	public WorkExperience2 getWorkExp() {
		return workExp;
	}

	public void setWorkExp(WorkExperience2 workExp) {
		this.workExp = workExp;
	}
	
	public void display()
	{
		System.out.println("name:" + this.name);
		System.out.println("age:" + this.age);
		System.out.println("WorkExperience:");
		System.out.println("timeArea:" + workExp.getTimeArea() + " " + "company:" + workExp.getCompany());
	}
	
	public Resume2 deepClone() throws IOException, ClassNotFoundException
	{
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		ObjectOutputStream oss = new ObjectOutputStream(bao);
		
		oss.writeObject(this);
		
		ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());;
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		return (Resume2)ois.readObject();
	}
}
