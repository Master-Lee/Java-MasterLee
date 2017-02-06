package com.lee.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

	//真实对象
	private Object subject;
	
	public DynamicProxy(Object subject) {
		this.subject = subject;
	}
	
	@Override
	public Object invoke(Object object, Method method, Object[] args)
			throws Throwable {
		System.out.println("before rent house");
		System.out.println("Method:" + method);
		
		method.invoke(subject, args);
		
		System.out.println("after rent house");
		return null;
	}

}
