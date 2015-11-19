package com.lightcat.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Test {
	public static void main(String[] args){
		/*if("/contextName/user/doUser.do".split("/")[0].equals("")){
			System.out.print("true...");
		}*/
		
		try {
			ServerSocket ss = new ServerSocket(33333);
			Socket s = ss.accept();
			s.getOutputStream().write(("HTTP/1.1 404 Not Found\r\n"+
										"Content-Type: text/html\r\n"+
										"\r\n").getBytes());
			s.getOutputStream().write("luoxiangsheng".getBytes());
			s.getOutputStream().write("HTTP/1.1 404 Not Found\r\n".getBytes());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
