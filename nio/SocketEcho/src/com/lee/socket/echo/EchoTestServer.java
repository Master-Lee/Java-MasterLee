package com.lee.socket.echo;

import java.util.concurrent.atomic.AtomicInteger;

public class EchoTestServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AtomicInteger count = new AtomicInteger();
		EchoServer echoServer = new EchoServer(count);
		new Thread(echoServer).start();
	}
}
