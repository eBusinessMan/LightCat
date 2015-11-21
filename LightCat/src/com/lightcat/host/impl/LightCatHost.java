package com.lightcat.host.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.lightcat.context.AppContext;
import com.lightcat.engine.Engine;
import com.lightcat.host.Host;
import com.lightcat.request.impl.LightCatRequest;
import com.lightcat.response.impl.LightCatResponse;

/**
 * 虚拟主机
 * @author LuoZhixiao
 */
public class LightCatHost implements Host {
	final Engine parentEngine;
	
	private Map appContextMap = new HashMap<String , AppContext>();
	
	public LightCatHost(Engine parentEngine){
		this.parentEngine = parentEngine;
		createAppContext();
	}
	
	/**根据请求的URI判断此主机下是否有匹配到对应的AppContext
	 * @param request
	 * @return
	 */
	public boolean lookForAppContext(LightCatRequest request){
		return appContextMap.get(request.getRequestURI().split("/")[1]) == null?false:true;
	}
	
	/**处理请求
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@Override
	public void handle(LightCatRequest request, LightCatResponse response) throws IOException {
		// TODO Auto-generated method stub
		AppContext targetContext = (AppContext)appContextMap.get(request.getRequestURI().split("/")[1]);
		targetContext.handle(request , response);
	}
	
	/**
	 * 根据配置文件创建本虚拟主机下的应用
	 */
	private void createAppContext(){
		/*
		 * 待完善......
		 */
	}

	public Map getAppContextMap() {
		return appContextMap;
	}

	public void setAppContextMap(Map appContextMap) {
		this.appContextMap = appContextMap;
	}

}
