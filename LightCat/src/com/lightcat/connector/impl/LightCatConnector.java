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
 * ������
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
		
		ServerSocket server = null ;//�������˱����׽���
		Socket aptSocket ;//�������˶�̬�����������׽���
		
		try {
			server = new ServerSocket(33333);
			System.out.println("�����������ڼ���......");
			while(true){
				aptSocket = server.accept();//�������˶�̬���������׽���
				System.out.println("�ͻ������ӳɹ�......");
				
				TcpSocket tempSocket = new TcpSocket(aptSocket);
				new Thread(tempSocket).start();//�����̣߳������ɴ��߳����Ӧ�ͻ��˽�����
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	class TcpSocket implements Runnable{
		private Socket aptSocket ;//�������˶�̬�����������׽���
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
				
				//���Engine����ƥ��Host��Context��Servlet
				for(Engine engine : engineList){
					if((!request.isHasHandle())&&engine.lookForHost(request)){//���������δ����
						request.setHasHandle(true);//��ʶ�������Ѿ�������
						engine.handle(request, response);
					}
				}
				//�������û��ƥ��Ĵ���
				if(request.isHasHandle()){
					/* �ϳ�http��Ӧ���ģ�404.....
					 * ������ͻ���
					 * ������......
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
