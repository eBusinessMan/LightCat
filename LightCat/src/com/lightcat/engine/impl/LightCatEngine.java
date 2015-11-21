package com.lightcat.engine.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.lightcat.engine.Engine;
import com.lightcat.host.Host;
import com.lightcat.request.impl.LightCatRequest;
import com.lightcat.response.impl.LightCatResponse;
import com.lightcat.service.impl.Service;

/**
 * 处理引擎
 * @author LuoZhixiao
 *
 */
public class LightCatEngine implements Engine{
	private final Service parentService;
	
	private Map hostMap = new HashMap<String , Host>();//key=host的name , value=host对象
	public LightCatEngine(Service parentService){
		this.parentService = parentService;
		createHost();
	}
	/**根据配置文件创建虚拟主机
	 * @return
	 */
	private Map createHost(){
		/*
		 * 待完善。。。。。。
		 */
		return null;
	}
	/**根据request的host属性匹配对应的Host
	 * @param request
	 * @return
	 */
	@Override
	public boolean lookForHost(LightCatRequest request){
		/*
		 * 待完善。。。。。。
		 */
		return true;
	}
	
	@Override
	public void handle(LightCatRequest request , LightCatResponse response) throws IOException {
		// TODO Auto-generated method stub
		Host host = (Host) hostMap.get(request.getHeader("Host"));
		host.handle(request, response);
	}
}