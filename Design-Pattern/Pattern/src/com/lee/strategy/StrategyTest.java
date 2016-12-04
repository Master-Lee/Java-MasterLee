package com.lee.strategy;

public class StrategyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StrategyContext context = new StrategyContext();
		
		ICalculate calcMethod = context.chooseCal("+");
		int result = calcMethod.executeCal(1, 1);
		System.out.println(result);
		
		calcMethod = context.chooseCal("-");
		result = calcMethod.executeCal(3, 1);
		System.out.println(result);
	}

}
