package com.lightcat.session.impl;

import java.util.Enumeration;
import java.util.HashMap;

import com.lightcat.context.impl.LightCatAppContext;
import com.lightcat.listener.event.impl.AttributeEvent;
import com.lightcat.listener.impl.SessionAttributeListener;
import com.lightcat.session.HttpSession;

/**封装本次会话的信息
 * @author LuoZhixiao
 *
 */
public class LightCatSession implements HttpSession{
	private SessionAttributeListener sessionAttributeListener = null;
	private HashMap<String , Object> attributeMap = new HashMap<String , Object>();
	private final LightCatAppContext appContext ;//session所在的appContext
	
	/**构造器
	 * @param appContext
	 */
	public LightCatSession(LightCatAppContext appContext){
		this.appContext = appContext ;
	}
	
	/**注册session属性监听器
	 * @param sessionAttributeListener
	 */
	public void registerAttributeListener(SessionAttributeListener sessionAttributeListener){
		this.sessionAttributeListener = sessionAttributeListener;
	}
	
	@Override
	public void removeAttribute(String s) {
		// TODO Auto-generated method stub
		if(this.sessionAttributeListener != null){
			this.sessionAttributeListener.attributeRemoved(new AttributeEvent(this,s,null));
		}
		this.attributeMap.remove(s);
	}
	
	@Override
	public void setAttribute(String s, Object obj) {
		// TODO Auto-generated method stub
		if(attributeMap.get(s) != null){//修改属性
			this.sessionAttributeListener.attributeModified(new AttributeEvent(this,s,obj));
		}else{//添加新属性
			if(this.sessionAttributeListener != null){
				this.sessionAttributeListener.attributeAdded(new AttributeEvent(this,s,obj));
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
	public long getCreationTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LightCatAppContext getAppContext() {
		// TODO Auto-generated method stub
		return this.appContext;
	}

	@Override
	public void setMaxInactiveInterval(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getMaxInactiveInterval() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Enumeration getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void invalidate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long getLastAccessedTime() {
		// TODO Auto-generated method stub
		return 0;
	}

}
