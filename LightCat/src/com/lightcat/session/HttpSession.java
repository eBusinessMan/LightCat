package com.lightcat.session;

import java.util.Enumeration;

import com.lightcat.context.impl.LightCatAppContext;

public interface HttpSession
{

    public abstract long getCreationTime();

    public abstract String getId();

    public abstract long getLastAccessedTime();

    public abstract LightCatAppContext getAppContext();

    public abstract void setMaxInactiveInterval(int i);

    public abstract int getMaxInactiveInterval();

    public abstract Object getAttribute(String s);

    public abstract Enumeration getAttributeNames();

    public abstract void setAttribute(String s, Object obj);

    public abstract void removeAttribute(String s);

    public abstract void invalidate();

    public abstract boolean isNew();
}