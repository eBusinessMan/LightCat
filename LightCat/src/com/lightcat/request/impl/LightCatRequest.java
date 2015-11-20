package com.lightcat.request.impl;

import java.util.Enumeration;
import java.util.HashMap;
import com.lightcat.context.AppContext;
import com.lightcat.context.impl.LightCatAppContext;
import com.lightcat.cookie.Cookie;
import com.lightcat.listener.event.impl.AttributeEvent;
import com.lightcat.listener.impl.RequestAttributeListener;
import com.lightcat.listener.impl.RequestLifecycleListener;
import com.lightcat.request.HttpRequest;
import com.lightcat.session.HttpSession;
import com.lightcat.session.impl.LightCatSession;

/**
 * @author LuoZhixiao
 * 封装了HTTP请求报文的所有信息
 */
public class LightCatRequest implements HttpRequest {
	
	/**
	 * 判断此请求是否被处理过了
	 */
	private boolean hasHandle = false;

	private HashMap<String , String> requestHeaderMap = null;
	
	private RequestAttributeListener attributeListener = null;
	private RequestLifecycleListener lifecycleListener = null;
	private HashMap<String , Object> attributeMap = new HashMap<String , Object>();
	private LightCatAppContext appContext ;//request所在的appContext
	private LightCatSession session;//session所在的appContext
	
	private String protocol ;
	private String method ;
	private String version ;
	/**构造器
	 * @param appContext
	 */
	public LightCatRequest(LightCatAppContext appContext , LightCatSession session){
		this.appContext = appContext;
		this.session = session;
	}
	
	public LightCatRequest(){}
	
	private void bindParent(LightCatSession session){
		if(this.session == null){
			this.session = session ;
		}
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
	
	public boolean isHasHandle() {
		return hasHandle;
	}

	public void setHasHandle(boolean hasHandle) {
		this.hasHandle = hasHandle;
	}
	
	@Override
	public Enumeration getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMethod() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRequestURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProtocol() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProtocolVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHeader(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enumeration getHeaders(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enumeration getHeaderNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cookie[] getCookies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppContext getAppContext() {
		// TODO Auto-generated method stub
		return this.session.getAppContext();
	}

	@Override
	public String getContextPath() {
		// TODO Auto-generated method stub
		return this.getAppContext().getRealPath();
	}

	@Override
	public HttpSession getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRequestedSessionId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isRequestedSessionIdValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRequestedSessionIdFromCookie() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRequestedSessionIdFromURL() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public void setMethod(String method) {
		this.method = method;
	}
}
