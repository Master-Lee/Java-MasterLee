package com.lee.deepcopy;

import java.io.Serializable;

public class Email implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3241481569190117114L;
	private String content;
	
	public Email(String content)
	{
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
