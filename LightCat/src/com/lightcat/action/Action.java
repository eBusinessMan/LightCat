package com.lightcat.action;

import java.io.IOException;

import com.lightcat.request.impl.LightCatRequest;
import com.lightcat.response.impl.LightCatResponse;

/**
 * ¿ØÖÆÆ÷½Ó¿Ú
 * @author LuoZhixiao
 */
public interface Action {
	void init();
	void destroy();
	
	void doGet(LightCatRequest req, LightCatResponse resp) throws IOException;

	long getLastModified(LightCatRequest req)throws IOException;

	void doHead(LightCatRequest req, LightCatResponse resp)throws IOException;

	void doPost(LightCatRequest req, LightCatResponse resp)throws IOException;

	void doPut(LightCatRequest req, LightCatResponse resp)throws IOException;

	void doDelete(LightCatRequest req, LightCatResponse resp)throws IOException;

	void handle(LightCatRequest req, LightCatResponse resp) throws IOException;

}
