package com.lee.socket.echo;

import java.io.IOException;
import java.net.UnknownHostException;

public class EchoTestClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args){
		try {
			new EchoClient("client 1");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
