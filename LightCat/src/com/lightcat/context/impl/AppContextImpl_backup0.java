package com.lightcat.context.impl;

import java.util.HashMap;
import java.util.Map;

import com.lightcat.context.AppContext;
import com.lightcat.host.Host;
import com.lightcat.request.impl.LightCatRequest;
import com.lightcat.response.impl.LightCatResponse;

/**�����Ų�����host�µĿ����ߵ�webapp
 * @author LuoZhixiao
 */
public class AppContextImpl_backup0 implements AppContext {
	final Host parentHost ;
	private Map servletMapping ;  
	
	public AppContextImpl_backup0(Host parentHost){
		this.parentHost = parentHost;
		servletMapping = createWholeServletMap();//����ӳ��
	}
	
	/**��������
	 * @param request
	 * @param response
	 */
	/*public void handle(Request request, Response_backup0 response) {
		// TODO Auto-generated method stub
		
	}
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * ���ԭʼServletӳ���jsp�������ɵ�Servlet��ӳ��
	 * @return
	 */
	private Map createWholeServletMap(){
		Map jsp_ServletMapping = createJsp2ServletMap();
		Map originalServletMapping = createOriginalServletMap();
		//���
		//Map servletMapping = new HashMap<String , HttpServletRequest>();
		/*
		 * ������
		 */
		return servletMapping;
	}
	
	/**
	 * ��ԭʼ��servelt���ز�����ӳ��
	 * @return
	 */
	private Map createOriginalServletMap(){
		/*
		 * ������......
		 */
		return null;
	}
	
	/**
	 * ��������ɵ�jsp���أ�������servlet���󣬲�����ӳ�䣺key=url-pattern , value=Servlet����
	 * @return
	 */
	private Map createJsp2ServletMap(){
		/*
		 * ������......
		 */
		return null;
	}
	
	/**
	 * ����jsp��ת����Servlet
	 */
	private void jspParse(){
		/*
		 * ����tomcat����ؽ���jsp�İ�
		 * ������......
		 */
	}

	@Override
	public void handle(LightCatRequest request, LightCatResponse response) {
		// TODO Auto-generated method stub
		
	}

}
