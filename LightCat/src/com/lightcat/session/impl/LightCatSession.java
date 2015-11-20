package com.lightcat.session.impl;

import java.util.Enumeration;
import java.util.HashMap;

import com.lightcat.context.impl.LightCatAppContext;
import com.lightcat.listener.event.impl.AttributeEvent;
import com.lightcat.listener.impl.SessionAttributeListener;
import com.lightcat.listener.impl.SessionLifecycleListener;
import com.lightcat.session.HttpSession;

/**封装本次会话的信息
 * @author LuoZhixiao
 * 
 * 想法：后期会抽离出注册各scope的各种监听器的代码独立出来
 *
 */
public class LightCatSession implements HttpSession{
	private SessionAttributeListener attributeListener = null;
	private SessionLifecycleListener lifecycleListener = null;
	private HashMap<String , Object> attributeMap = new HashMap<String , Object>();
	private final LightCatAppContext appContext ;//session所在的appContext
	
	/**构造器
	 * @param appContext
	 */
	public LightCatSession(LightCatAppContext appContext){
		this.appContext = appContext ;
	}
	
	/**注册属性监听器
	 * @param sessionAttributeListener
	 */
	public void registerAttributeListener(SessionAttributeListener sessionAttributeListener){
		this.attributeListener = sessionAttributeListener;
	}
	
	/**注册生命周期监听器
	 * @param lifecycleListener
	 */
	public void registerLifecycleListener(SessionLifecycleListener lifecycleListener){
		this.lifecycleListener = lifecycleListener;
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
