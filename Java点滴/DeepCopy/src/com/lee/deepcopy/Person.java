package com.lee.deepcopy;

import java.io.Serializable;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6551377493929923764L;
	private String name;
	private Email email;
	public Person(String name, Email email)
	{
		this.name = name;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Person(String name)
	{
		this.name = name;
	}
}
