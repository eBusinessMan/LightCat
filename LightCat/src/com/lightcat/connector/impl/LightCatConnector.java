package com.lightcat.connector.impl;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.lightcat.common.util.RequestHandler;
import com.lightcat.common.util.ResponseHandler;
import com.lightcat.engine.Engine;
import com.lightcat.request.impl.LightCatRequest;
import com.lightcat.response.impl.LightCatResponse;
import com.lightcat.service.impl.Service;

/**
 * 监听器
 * @author LuoZhixiao
 */
public class LightCatConnector {
	private final Service parentService;
	public LightCatConnector(Service parentService){
		this.parentService = parentService;
	}
	private ArrayList<Engine> engineList;
	
	public void startListen(ArrayList<Engine> engineList) {
		// TODO Auto-generated method stub
		this.engineList = engineList;
		
		ServerSocket server = null ;//服务器端被动套接字
		Socket aptSocket ;//服务器端动态创建的主动套接字
		
		try {
			server = new ServerSocket(33333);
			System.out.println("服务器端正在监听......");
			while(true){
				aptSocket = server.accept();//服务器端动态创建主动套接字
				System.out.println("客户端连接成功......");
				
				TcpSocket tempSocket = new TcpSocket(aptSocket);
				new Thread(tempSocket).start();//创建线程，并交由此线程与对应客户端交互。
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	class TcpSocket implements Runnable{
		private Socket aptSocket ;//服务器端动态创建的主动套接字
		public TcpSocket(Socket aptSocket){
			this.aptSocket = aptSocket;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			OutputStream os;
			InputStream is;
			try {
				os = aptSocket.getOutputStream();
				is = aptSocket.getInputStream();
				LightCatRequest request = RequestHandler.inputStream2Request(is);
				LightCatResponse response = ResponseHandler.outputStream2Response(os);
				
				//逐个Engine对象匹配Host、Context、Servlet
				for(Engine engine : engineList){
					if((!request.isHasHandle())&&engine.lookForHost(request)){//如果请求尚未处理
						request.setHasHandle(true);//标识此请求已经被处理
						engine.handle(request, response);
					}
				}
				//如果请求没有匹配的处理
				if(request.isHasHandle()){
					/* 合成http响应报文：404.....
					 * 输出给客户端
					 * 待完善......
					 */
				}
				aptSocket.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
