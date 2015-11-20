package com.lightcat.request;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;

import com.lightcat.context.AppContext;
import com.lightcat.context.impl.LightCatAppContext;
import com.lightcat.cookie.Cookie;
import com.lightcat.session.HttpSession;

public interface HttpRequest
    extends Request
{
	/*
	 * ������
	 */
    public abstract String getMethod();
    public abstract String getRequestURI();
    public abstract String getProtocol();
    public abstract String getProtocolVersion();

    /*
     * ����ͷ
     */
    public abstract String getHeader(String s);
    public abstract Enumeration getHeaders(String s);
    public abstract Enumeration getHeaderNames();

    /*
     * cookie
     */
    public abstract Cookie[] getCookies();
    
    /*
     *appContext��� 
     */
    public abstract AppContext getAppContext();
    public abstract String getContextPath();

    /*
     *session��� 
     */
    public abstract HttpSession getSession();
    public abstract String getRequestedSessionId();
    public abstract boolean isRequestedSessionIdValid();
    public abstract boolean isRequestedSessionIdFromCookie();
    public abstract boolean isRequestedSessionIdFromURL();
}