package com.lee.clone.deep;

import java.io.IOException;

import com.lee.clone.WorkExperience;

public class CloneTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resume2 resu = new Resume2("lee",28);
		WorkExperience2 workExp = new WorkExperience2("2013-2015","Huawei");
		resu.setWorkExp(workExp);
		
		Resume2 resuClone = null;
		try {
			resuClone = resu.deepClone();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resuClone.setName("wang");
		resuClone.setAge(30);
		resuClone.getWorkExp().setCompany("ZTE");
		resuClone.getWorkExp().setTimeArea("2012-2016");
		
		resu.display();
		resuClone.display();
	}

}

