package com.lee.socket.echo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
	private Socket cSocket;
	private String name;
	public EchoClient(String name) throws UnknownHostException, IOException {
		this.cSocket = new Socket("localhost", 3000);
		this.setName(name);
		
		Thread writeThread = new WriteThread();
		Thread readThread = new ReadThread();
		writeThread.start();
		readThread.start();
		try {
			writeThread.join();
			readThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private class WriteThread extends Thread
	{	
		public void run()
		{
			BufferedReader br = null;
			BufferedOutputStream bos = null;
			String content = null;
			byte[] buf = null;
			
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				bos = new BufferedOutputStream(cSocket.getOutputStream());
				while(true)
				{
					System.out.println("===> Please input :");
					content = br.readLine();
					buf = content.getBytes();
					bos.write(buf);
					bos.flush();
					
					if (content.equalsIgnoreCase("over"))
					{
						break;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private class ReadThread extends Thread
	{
		BufferedInputStream bis = null;
		byte[] buf = new byte[1024];
		String content = null;
		int readByte = -1;
		public void run()
		{
			try {
				bis = new BufferedInputStream(cSocket.getInputStream());
				while(true)
				{
					readByte = bis.read(buf);
					content = new String(buf,0,readByte);
					System.out.println("<===Server Echo : " + content);
					if (content.equalsIgnoreCase("over"))
					{
						System.out.println(">>> Echo End! <<<");
						break;
					}
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
