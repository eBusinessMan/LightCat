package com.lightcat.service.impl;

import java.util.ArrayList;

import com.lightcat.connector.impl.LightCatConnector;
import com.lightcat.engine.Engine;
import com.lightcat.server.Server;

public class Service {
	private final Server parentServer;
	
	private ArrayList<LightCatConnector> connectorList = new ArrayList<LightCatConnector>();
	private ArrayList<Engine> engineList = new ArrayList<Engine>();
	
	public Service(Server parentServer){
		this.parentServer = parentServer;
	}
	
	public void createConnectors(){}//根据配置文件创建Connector对象
	
	public void createEngines(){}//根据配置文件创建Engine对象
	
	public void startService(){
		createConnectors();
		createEngines();
		
		for(LightCatConnector connector : connectorList){
			connector.startListen(engineList);
		}
	}
}
