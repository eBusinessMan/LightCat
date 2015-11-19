package com.lightcat.response;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;

public interface Response_backup0
{

    public abstract String getCharacterEncoding();

    public abstract String getContentType();

    public abstract OutputStream getOutputStream()
        throws IOException;

    public abstract PrintWriter getWriter()
        throws IOException;

    public abstract void setCharacterEncoding(String s);

    public abstract void setContentLength(int i);

    public abstract void setContentType(String s);

    public abstract void setBufferSize(int i);

    public abstract int getBufferSize();

    public abstract void flushBuffer()
        throws IOException;

    public abstract void resetBuffer();

    public abstract boolean isCommitted();

    public abstract void reset();

    public abstract void setLocale(Locale locale);

    public abstract Locale getLocale();
}
