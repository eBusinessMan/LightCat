package com.lightcat.response;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;

public interface Response_backup1 {
	OutputStream getOutputStream() throws IOException;

	PrintWriter getWriter() throws IOException;

	
	
	
	void setProtocal(String s);

	String getProtocal();

	void setStatusCode(String s);

	String getStatusCode();

	void setContentType(String s);

	String getContentType();

	void setContentLength(int i);

	String getContentLength();

	void setConnection(String s);

	String getConnecton();

	void setCacheControl(String s);

	String getCacheControl();

	void setExpires(String s);

	String getExpires();

	void setLastModified(String s);

	String getLastModified();

	String getCharacterEncoding();

	void setCharacterEncoding(String s);

	void setLocale(Locale locale);

	Locale getLocale();

	int getBufferSize();

}
