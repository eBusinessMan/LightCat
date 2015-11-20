package com.lightcat.context;

import java.util.Enumeration;

import com.lightcat.common.interfaces.Handler;

public interface AppContext extends Handler{
	   public abstract Enumeration getAttributeNames();
	    public abstract void setAttribute(String s, Object obj);
	    public abstract Object getAttribute(String s);
	    public abstract void removeAttribute(String s);
		/**��ȡ��webapp������·�������ԣ�
		 * @return
		 */
		public abstract String getRealPath();
}
