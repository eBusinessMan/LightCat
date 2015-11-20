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

	public void handle(LightCatRequest req, LightCatResponse resp)
			throws IOException {// �൱��Servlet�е�service
		switch (req.getMethod()) {
		case HttpMethodConstant.GET:
			this.doGet(req, resp);
			break;
		case HttpMethodConstant.POST:
			this.doPost(req, resp);
			break;
		case HttpMethodConstant.HEAD:
			this.doHead(req, resp);
			break;
		case HttpMethodConstant.PUT:
			this.doPut(req, resp);
			break;
		case HttpMethodConstant.DELETE:
			this.doDelete(req, resp);
			break;
		}
	}

	public void doGet(LightCatRequest req, LightCatResponse resp)
			throws IOException {
		resp.getOutputStream().write(
				"sorry!The HTTP Server does not support this method..."
						.getBytes("UTF-8"));
		resp.getOutputStream().flush();
	}

	public long getLastModified(LightCatRequest req) {
		return -1L;
	}

	public void doHead(LightCatRequest req, LightCatResponse resp)
			throws IOException {
		resp.getOutputStream().write(
				"sorry!The HTTP Server does not support this method..."
						.getBytes("UTF-8"));
		resp.getOutputStream().flush();
	}

	public void doPost(LightCatRequest req, LightCatResponse resp)
			throws IOException {
		resp.getOutputStream().write(
				"sorry!The HTTP Server does not support this method..."
						.getBytes("UTF-8"));
		resp.getOutputStream().flush();
	}

	public void doPut(LightCatRequest req, LightCatResponse resp)
			throws IOException {
		resp.getOutputStream().write(
				"sorry!The HTTP Server does not support this method..."
						.getBytes("UTF-8"));
		resp.getOutputStream().flush();
	}

	public void doDelete(LightCatRequest req, LightCatResponse resp)
			throws IOException {
		resp.getOutputStream().write(
				"sorry!The HTTP Server does not support this method..."
						.getBytes("UTF-8"));
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
