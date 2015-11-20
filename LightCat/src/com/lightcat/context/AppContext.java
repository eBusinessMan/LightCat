package com.lightcat.context;

import java.util.Enumeration;

import com.lightcat.common.interfaces.Handler;

public interface AppContext extends Handler{
	   public abstract Enumeration getAttributeNames();
	    public abstract void setAttribute(String s, Object obj);
	    public abstract Object getAttribute(String s);
	    public abstract void removeAttribute(String s);
		/**获取此webapp的物理路径（绝对）
		 * @return
		 */
		public abstract String getRealPath();
}
