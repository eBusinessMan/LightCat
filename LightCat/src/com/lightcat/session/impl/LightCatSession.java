package com.lightcat.session.impl;

import java.util.Enumeration;
import java.util.HashMap;

import com.lightcat.context.impl.LightCatAppContext;
import com.lightcat.listener.event.impl.AttributeEvent;
import com.lightcat.listener.impl.SessionAttributeListener;
import com.lightcat.listener.impl.SessionLifecycleListener;
import com.lightcat.session.HttpSession;

/**��װ���λỰ����Ϣ
 * @author LuoZhixiao
 * 
 * �뷨�����ڻ�����ע���scope�ĸ��ּ������Ĵ����������
 *
 */
public class LightCatSession implements HttpSession{
	private SessionAttributeListener attributeListener = null;
	private SessionLifecycleListener lifecycleListener = null;
	private HashMap<String , Object> attributeMap = new HashMap<String , Object>();
	private final LightCatAppContext appContext ;//session���ڵ�appContext
	
	/**������
	 * @param appContext
	 */
	public LightCatSession(LightCatAppContext appContext){
		this.appContext = appContext ;
	}
	
	/**ע�����Լ�����
	 * @param sessionAttributeListener
	 */
	public void registerAttributeListener(SessionAttributeListener sessionAttributeListener){
		this.attributeListener = sessionAttributeListener;
	}
	
	/**ע���������ڼ�����
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
		if(attributeMap.get(s) != null){//�޸�����
			this.attributeListener.attributeModified(new AttributeEvent(this,s,obj));
		}else{//���������
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
