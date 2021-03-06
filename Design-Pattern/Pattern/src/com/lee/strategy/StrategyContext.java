package com.lee.strategy;

public class StrategyContext {
	public ICalculate chooseCal(String cal)
	{
		ICalculate calMethod = null;
		
		if ("-".equals(cal))
		{
			calMethod = new MinuStrategy();
		}
		
		if ("+".equals(cal))
		{
			calMethod = new PlusStrategy();
		}
		
		return calMethod;
	}
}
