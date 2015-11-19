package com.lightcat.engine.impl;

import java.util.HashMap;
import java.util.Map;

import com.lightcat.engine.Engine;
import com.lightcat.host.Host;
import com.lightcat.request.impl.LightCatRequest;
import com.lightcat.response.impl.LightCatResponse;
import com.lightcat.service.impl.Service;

/**
 * ��������
 * @author LuoZhixiao
 *
 */
public class LightCatEngine implements Engine{
	private final Service parentService;
	
	private Map hostMap = new HashMap<String , Host>();//key=host��name , value=host����
	public LightCatEngine(Service parentService){
		this.parentService = parentService;
		createHost();
	}
	/**���������ļ�������������
	 * @return
	 */
	private Map createHost(){
		/*
		 * �����ơ�����������
		 */
		return null;
	}
	/**����request��host����ƥ���Ӧ��Host
	 * @param request
	 * @return
	 */
	@Override
	public boolean lookForHost(LightCatRequest request){
		/*
		 * �����ơ�����������
		 */
		return true;
	}
	
	@Override
	public void handle(LightCatRequest request , LightCatResponse response) {
		// TODO Auto-generated method stub
		Host host = (Host) hostMap.get(request.getRemoteHost());
		host.handle(request, response);
	}
}