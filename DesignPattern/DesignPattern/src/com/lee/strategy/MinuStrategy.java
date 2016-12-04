package com.lee.strategy;

public class MinuStrategy implements ICalculate {

	public int executeCal(int rNum, int lNum) {
		return rNum - lNum;
	}
}
