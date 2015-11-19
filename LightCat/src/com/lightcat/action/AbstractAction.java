package com.lightcat.action;

import java.io.IOException;

import com.lightcat.request.impl.LightCatRequest;
import com.lightcat.response.impl.LightCatResponse;

/**
 * �����࣬���е��Զ����Action�඼�̳�֮ ��װ��JSON,XML�����ȹ�������
 * 
 * @author LuoZhixiao
 */
public abstract class AbstractAction implements Action {

	public void doGet(LightCatRequest req, LightCatResponse resp)
			throws IOException {
		resp.getOutputStream().write("sorry!The HTTP Server does not support this method...".getBytes("UTF-8"));
		resp.getOutputStream().flush();
	}

	public long getLastModified(LightCatRequest req) {
		return -1L;
	}

	public void doHead(LightCatRequest req, LightCatResponse resp)
			throws IOException {
		resp.getOutputStream().write("sorry!The HTTP Server does not support this method...".getBytes("UTF-8"));
		resp.getOutputStream().flush();
	}

	public void doPost(LightCatRequest req, LightCatResponse resp)
			throws IOException {
		resp.getOutputStream().write("sorry!The HTTP Server does not support this method...".getBytes("UTF-8"));
		resp.getOutputStream().flush();
	}

	public void doPut(LightCatRequest req, LightCatResponse resp)
			throws IOException {
		resp.getOutputStream().write("sorry!The HTTP Server does not support this method...".getBytes("UTF-8"));
		resp.getOutputStream().flush();
	}

	public void doDelete(LightCatRequest req, LightCatResponse resp)
			throws IOException {
		resp.getOutputStream().write("sorry!The HTTP Server does not support this method...".getBytes("UTF-8"));
		resp.getOutputStream().flush();
	}

	/**
	 * ������תΪjson�ַ���
	 * 
	 * @param o
	 * @return
	 */
	public String object2Json(Object o) {
		return null;
	}

	/**
	 * ������תΪxml�ַ���
	 * 
	 * @param o
	 * @return
	 */
	public String object2Xml(Object o) {
		return null;
	}
}
