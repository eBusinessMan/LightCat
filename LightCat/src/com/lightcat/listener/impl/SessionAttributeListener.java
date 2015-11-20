package com.lightcat.listener.impl;

import com.lightcat.listener.AttributeListener;
import com.lightcat.listener.event.impl.AttributeEvent;

public abstract class SessionAttributeListener implements AttributeListener {
	@Override
	public void attributeAdded(AttributeEvent attributeEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeRemoved(AttributeEvent attributeEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeModified(AttributeEvent attributeEvent) {
		// TODO Auto-generated method stub
		
	}
	public void sessionCreated(){}
	public void sessionDestroyed(){}
}
