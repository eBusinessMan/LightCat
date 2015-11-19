package com.lightcat.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import com.lightcat.context.impl.LightCatAppContext;

public interface Request
{

    public abstract Object getAttribute(String s);

    public abstract Enumeration getAttributeNames();

    public abstract String getCharacterEncoding();

    public abstract void setCharacterEncoding(String s)
        throws UnsupportedEncodingException;

    public abstract int getContentLength();

    public abstract String getContentType();

    public abstract InputStream getInputStream()
        throws IOException;

    public abstract String getParameter(String s);

    public abstract Enumeration getParameterNames();

    public abstract String[] getParameterValues(String s);

    public abstract Map getParameterMap();

    public abstract String getProtocol();

    public abstract String getScheme();

    public abstract String getServerName();

    public abstract int getServerPort();

    public abstract BufferedReader getReader()
        throws IOException;

    public abstract String getRemoteAddr();

    public abstract String getRemoteHost();

    public abstract void setAttribute(String s, Object obj);

    public abstract void removeAttribute(String s);

    public abstract Locale getLocale();

    public abstract Enumeration getLocales();

    public abstract boolean isSecure();

//    public abstract RequestDispatcher getRequestDispatcher(String s);

    /**
     * @deprecated Method getRealPath is deprecated
     */

    public abstract String getRealPath(String s);

    public abstract int getRemotePort();

    public abstract String getLocalName();

    public abstract String getLocalAddr();

    public abstract int getLocalPort();

    public abstract LightCatAppContext getAppContext();

/*    public abstract AsyncContext startAsync()
        throws IllegalStateException;

    public abstract AsyncContext startAsync(ServletRequest servletrequest, ServletResponse servletresponse)
        throws IllegalStateException;

    public abstract boolean isAsyncStarted();

    public abstract boolean isAsyncSupported();

    public abstract AsyncContext getAsyncContext();

    public abstract DispatcherType getDispatcherType();*/
}
