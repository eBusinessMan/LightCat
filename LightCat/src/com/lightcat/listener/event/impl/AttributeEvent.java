package com.lightcat.listener.event.impl;

import com.lightcat.listener.event.Event;
import com.lightcat.listener.event.EventType;

/**
 * �����¼����󣬷�װ�� ���¼�Դ��������������ֵ���¼�����
 * @author LuoZhixiao
 *
 */
public class AttributeEvent implements Event {
	private Object source ;
	private String attributeName ;
	private Object attributeValue ;
	private String eventType = EventType.UNKNOWN;

	public AttributeEvent(Object source , String attributeName , Object attributeValue , String eventType){
		this.source = source;
		this.attributeName = attributeName;
		this.attributeValue = attributeValue;
		this.eventType = eventType;
	}
	
	public AttributeEvent(Object source , String attributeName , Object attributeValue){
		this(source , attributeName , attributeValue , null);
	}
	
	@Override
	public Object getSource() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getEventType() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getAttributeName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getAttributeValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
