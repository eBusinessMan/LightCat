package com.lightcat.context.impl;

import java.util.HashMap;
import java.util.Map;

import com.lightcat.context.AppContext;
import com.lightcat.host.Host;
import com.lightcat.request.impl.LightCatRequest;
import com.lightcat.response.impl.LightCatResponse;

/**代表着部署在host下的开发者的webapp
 * @author LuoZhixiao
 */
public class AppContextImpl_backup0 implements AppContext {
	final Host parentHost ;
	private Map servletMapping ;  
	
	public AppContextImpl_backup0(Host parentHost){
		this.parentHost = parentHost;
		servletMapping = createWholeServletMap();//创建映射
	}
	
	/**处理请求
	 * @param request
	 * @param response
	 */
	/*public void handle(Request request, Response_backup0 response) {
		// TODO Auto-generated method stub
		
	}
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 拟合原始Servlet映射和jsp解析生成的Servlet的映射
	 * @return
	 */
	private Map createWholeServletMap(){
		Map jsp_ServletMapping = createJsp2ServletMap();
		Map originalServletMapping = createOriginalServletMap();
		//拟合
		//Map servletMapping = new HashMap<String , HttpServletRequest>();
		/*
		 * 待完善
		 */
		return servletMapping;
	}
	
	/**
	 * 将原始的servelt加载并创建映射
	 * @return
	 */
	private Map createOriginalServletMap(){
		/*
		 * 待完善......
		 */
		return null;
	}
	
	/**
	 * 将解析完成的jsp加载，即加载servlet对象，并生成映射：key=url-pattern , value=Servlet对象
	 * @return
	 */
	private Map createJsp2ServletMap(){
		/*
		 * 待完善......
		 */
		return null;
	}
	
	/**
	 * 解析jsp，转化成Servlet
	 */
	private void jspParse(){
		/*
		 * 借助tomcat的相关解析jsp的包
		 * 待完善......
		 */
	}

	@Override
	public void handle(LightCatRequest request, LightCatResponse response) {
		// TODO Auto-generated method stub
		
	}

}
