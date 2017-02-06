package com.lee.clone;

public class CloneTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resume resu = new Resume("lee",28);
		WorkExperience workExp = new WorkExperience("2013-2015","Huawei");
		resu.setWorkExp(workExp);
		
		Resume resuClone = resu.clone();
		resuClone.setName("wang");
		resuClone.setAge(30);
		resuClone.getWorkExp().setCompany("ZTE");
		resuClone.getWorkExp().setTimeArea("2012-2016");
		
		resu.display();
		resuClone.display();
	}

}
