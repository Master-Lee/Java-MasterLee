package com.lee.strategy;

public class PlusStrategy implements ICalculate {

	public int executeCal(int rNum, int lNum) {
		return rNum + lNum;
	}
}
