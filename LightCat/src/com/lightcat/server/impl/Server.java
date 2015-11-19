package com.lightcat.server.impl;

import java.util.ArrayList;

import com.lightcat.service.impl.Service;

public class Server {
	private ArrayList<Service> serviceList = new ArrayList<Service>();
	
	/**
	 * �������ļ��д���Serviceʵ������,����ӵ�serviceList
	 */
	public void createServices(){
		/*
		 * �����ơ���������
		 */
	}
	
	public void startServer(){
		createServices();//����Service����
		for(Service service : serviceList){
			service.startService();
		}
	}
	public static void main(String[] args){
		new Server().startServer();
	}
}
