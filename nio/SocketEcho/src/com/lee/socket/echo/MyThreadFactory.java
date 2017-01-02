package com.lee.socket.echo;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadFactory implements ThreadFactory {
	private AtomicInteger count;

	MyThreadFactory(AtomicInteger count)
	{
		this.count = count;
	}
	
	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		int c = count.incrementAndGet();
		t.setName("服务端线程" + c);
		t.setDaemon(false);
		return t;
	}
}
