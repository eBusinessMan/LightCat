package com.lightcat.context.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import com.lightcat.action.Action;
import com.lightcat.common.urltree.UrlLinkNode;
import com.lightcat.common.urltree.UrlTreeNode;
import com.lightcat.context.AppContext;
import com.lightcat.host.Host;
import com.lightcat.listener.event.impl.AttributeEvent;
import com.lightcat.listener.impl.AppContextAttributeListener;
import com.lightcat.listener.impl.AppContextLifecycleListener;
import com.lightcat.request.impl.LightCatRequest;
import com.lightcat.response.impl.LightCatResponse;

/**
 * 代表着部署在host下的开发者的webapp
 * @author LuoZhixiao
 * 
 * 一个想法：后期会抽离出注册各scope的各种监听器的代码独立出来
 */
public class LightCatAppContext implements AppContext {
	final Host parentHost;
	private String ContextName;// 这个web应用的名字

	private UrlTreeNode urlTree_root;// url树的根
										// ，此根的segName是“/本context名字”，即以“/本context名字”开始

	private String file404 ;//404页面，从配置文件中读取，如果用户有配置的话
	private String fileError ; //error页面，从配置文件中读取，如果用户有配置的话
	private ArrayList<String> fileWelcome ;//欢迎页面:
	
	private AppContextLifecycleListener lifecycleListener ;
	private AppContextAttributeListener attributeListener ;
	
	/**
	 * 封装了本appcontext对应的配置文件
	 * 待完善......
	 */
	private String DOM ;
	
	private HashMap<String , Object> attributeMap = new HashMap<String , Object>(); 
	
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

	public ArrayList<String> getFileWelcome() {
		return fileWelcome;
	}

	public void setFileWelcome(ArrayList<String> fileWelcome) {
		this.fileWelcome = fileWelcome;
	}
	
	/**
	 * 注册属性状态监听器
	 * @param attributeListener
	 */
	public void registerAttributeListener(AppContextAttributeListener attributeListener){
		this.attributeListener = attributeListener;
	}
	/**注册生命周期监听器
	 * @param lifecycleListener
	 */
	public void registerLifecycleListener(AppContextLifecycleListener lifecycleListener){
		this.lifecycleListener = lifecycleListener;
		this.lifecycleListener.scopeCreated();//一旦注册就得执行此方法。
	}

	@Override
	public Enumeration getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttribute(String s, Object obj) {
		// TODO Auto-generated method stub
		if(attributeMap.get(s) != null){//修改属性
			this.attributeListener.attributeModified(new AttributeEvent(this,s,obj));
		}else{//添加新属性
			if(this.attributeListener != null){
				this.attributeListener.attributeAdded(new AttributeEvent(this,s,obj));
			}
		}
		this.attributeMap.put(s, obj);
	}

	@Override
	public Object getAttribute(String s) {
		// TODO Auto-generated method stub
		return this.attributeMap.get(s);
	}

	@Override
	public void removeAttribute(String s) {
		// TODO Auto-generated method stub
		if(this.attributeListener != null){
			this.attributeListener.attributeRemoved(new AttributeEvent(this,s,null));
		}
		this.attributeMap.remove(s);
	}

	@Override
	public String getRealPath() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
