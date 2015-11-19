package com.lightcat.context.impl;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.lightcat.action.Action;
import com.lightcat.common.urltree.UrlTreeNode;
import com.lightcat.context.AppContext;
import com.lightcat.host.Host;
import com.lightcat.request.impl.LightCatRequest;
import com.lightcat.response.impl.LightCatResponse;

/**代表着部署在host下的开发者的webapp
 * @author LuoZhixiao
 */
public class LightCatAppContext_backup0 implements AppContext {
	final Host parentHost ;
	private Map servletMapping ;
	
	private UrlTreeNode urlTree_root ;//url树的根 ，此根的segName是“/本context名字”，即以“/本context名字”开始
	
	public LightCatAppContext_backup0(Host parentHost){
		this.parentHost = parentHost;
		servletMapping = createActionMap();//创建映射
	}
	
	/**处理请求
	 * @param request
	 * @param response
	 */
	@Override
	public void handle(LightCatRequest request, LightCatResponse response) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 原始Servlet映射
	 * @return
	 */
	private Map createActionMap(){
		//拟合
		Map servletMapping = new HashMap<String , Action>();
		/*
		 * 待完善
		 */
		return servletMapping;
	}

	/**
	 * @return the urlTree_root
	 */
	public UrlTreeNode getUrlTree_root() {
		return urlTree_root;
	}

	/**
	 * @param urlTree_root the urlTree_root to set
	 */
	public void setUrlTree_root(UrlTreeNode urlTree_root) {
		this.urlTree_root = urlTree_root;
	}

}
