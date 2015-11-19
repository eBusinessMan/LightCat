package com.lightcat.server.impl;

import java.util.ArrayList;

import com.lightcat.service.impl.Service;

public class Server {
	private ArrayList<Service> serviceList = new ArrayList<Service>();
	
	/**
	 * 从配置文件中创建Service实例对象,并添加到serviceList
	 */
	public void createServices(){
		/*
		 * 待完善。。。。。
		 */
	}
	
	public void startServer(){
		createServices();//创建Service对象
		for(Service service : serviceList){
			service.startService();
		}
	}
	public static void main(String[] args){
		new Server().startServer();
	}
}
