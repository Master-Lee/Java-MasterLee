package com.lee.socket.echo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class ServerEchoWorker implements Runnable {
	private Socket socket;
	
	AtomicInteger count;
	
	ServerEchoWorker(Socket socket, AtomicInteger count)
	{
		this.socket = socket;
		this.count = count;
	}
	
	@Override
	public void run() {
        BufferedInputStream bis = null;  
        BufferedWriter bw = null;  
		try {
            //读取和写入流的初始化  
            bis = new BufferedInputStream(socket.getInputStream());  
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));  
            String readString = null;  
            String writeString = null;  
            byte[] buf = new byte[1024];  
            int len = -1;  
			while(true)
			{
                //从流中获取客户端写入的信息，会阻塞等待  
                len = bis.read(buf);              
                readString = new String(buf, 0, len);  
                writeString = readString.toUpperCase();  
                
                bw.write(writeString);  
                bw.flush(); 
                
                if (readString.equalsIgnoreCase("over")) {
                    break;  
                } 
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null)
				{
					bis.close();
				}
				
				if (bw != null)
				{
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
