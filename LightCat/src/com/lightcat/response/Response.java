package com.lightcat.response;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * ×î¶¥½Ó¿Ú
 * @author LuoZhixiao
 *
 */
public interface Response
{

    public abstract OutputStream getOutputStream()
        throws IOException;

    public abstract PrintWriter getWriter()
        throws IOException;

}
