package com.lightcat.context.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.lightcat.action.Action;
import com.lightcat.common.urltree.UrlLinkNode;
import com.lightcat.common.urltree.UrlTreeNode;
import com.lightcat.context.AppContext;
import com.lightcat.host.Host;
import com.lightcat.request.impl.LightCatRequest;
import com.lightcat.response.impl.LightCatResponse;

/**
 * 代表着部署在host下的开发者的webapp
 * 
 * @author LuoZhixiao
 */
public class LightCatAppContext implements AppContext {
	final Host parentHost;
	private String ContextName;// 这个web应用的名字

	private UrlTreeNode urlTree_root;// url树的根
										// ，此根的segName是“/本context名字”，即以“/本context名字”开始

	private String file404 ;//404页面，从配置文件中读取，如果用户有配置的话
	private String fileError ; //error页面，从配置文件中读取，如果用户有配置的话
	
	public LightCatAppContext(Host parentHost) {
		this.parentHost = parentHost;
	}

	/**
	 * 处理请求
	 * 
	 * @param request
	 * @param response
	 */
	@Override
	public void handle(LightCatRequest request, LightCatResponse response) {
		// TODO Auto-generated method stub
		UrlLinkNode urlLinkNode_root = createRequestUrlLink(request);
		// 开始匹配路径并处理
		urlTree_root.handle(urlLinkNode_root);

		// 如果请求uri已经到达了最后依然没有处理
		if (!request.isHasHandle()) {
			response.return404(new File(file404));
		}

	}

	public UrlLinkNode createRequestUrlLink(LightCatRequest request) {
		String requestUri = request.getRequestURI();
		String[] uriArray = requestUri.split("/");// 分割

		UrlLinkNode urlLinkNode_root = new UrlLinkNode("/" + uriArray[1]);// 索引0是空，跳过；索引1的是本context的名字，作为根
		UrlLinkNode urlLinkNode_last = urlLinkNode_root;// 当前链表的最后一个，初始化时指向头节点
		for (int i = 2; i < uriArray.length; i++) {// 从索引2 开始 循环生成链表
			UrlLinkNode urlLinkNode_temp = new UrlLinkNode("/" + uriArray[i]);
			urlLinkNode_last.setNext(urlLinkNode_temp);
			urlLinkNode_last = urlLinkNode_temp;
		}

		return urlLinkNode_root;
	}

	/**
	 * @return the urlTree_root
	 */
	public UrlTreeNode getUrlTree_root() {
		return urlTree_root;
	}

	/**
	 * @param urlTree_root
	 *            the urlTree_root to set
	 */
	public void setUrlTree_root(UrlTreeNode urlTree_root) {
		this.urlTree_root = urlTree_root;
	}

	public String getContextName() {
		return ContextName;
	}

	public void setContextName(String contextName) {
		ContextName = contextName;
	}

}
