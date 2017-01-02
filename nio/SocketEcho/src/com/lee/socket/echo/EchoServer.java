package com.lee.socket.echo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class EchoServer implements Runnable {
	ServerSocket sSocket;
	Socket cSocket;
	AtomicInteger count;
	
	EchoServer(AtomicInteger count)
	{
		try {
			this.sSocket = new ServerSocket(3000);
			sSocket.setSoTimeout(60000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.count = count;
	}

	@Override
	public void run() {
		MyThreadFactory threadFactory = new MyThreadFactory(count);
		ExecutorService ctp = Executors.newCachedThreadPool(threadFactory);
		try {
			while(true)
			{	
				try {
					cSocket = sSocket.accept();
				} catch(SocketTimeoutException e)
				{
					break;
				}
				
				ctp.execute(new ServerEchoWorker(cSocket,count));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			ctp.shutdown();
		}
	}
}
