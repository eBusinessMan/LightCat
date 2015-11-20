package com.lightcat.listener;

import com.lightcat.listener.event.impl.AttributeEvent;

public interface AttributeListener {
	public void attributeAdded(AttributeEvent attributeEvent);
	public void attributeRemoved(AttributeEvent attributeEvent);
	public void attributeModified(AttributeEvent attributeEvent);	
}
