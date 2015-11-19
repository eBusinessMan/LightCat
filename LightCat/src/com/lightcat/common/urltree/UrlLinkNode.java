package com.lightcat.common.urltree;

import com.lightcat.request.impl.LightCatRequest;
import com.lightcat.response.impl.LightCatResponse;

/**
 * request���������URI��·��segment�ڵ㣬LightCat�Ὣ֮�ϳ�url������
 * @author LuoZhixiao
 *
 */
public class UrlLinkNode{
	private String segName ;//��ʽ��/urlSegment,�磺/user
	private UrlLinkNode next ;//��һ��url segment
	
	private LightCatRequest request;//������ÿ��node��ָ�򱾴�����������ڹ���ʱ���Դ���request����
	private LightCatResponse response ;
	
	public UrlLinkNode(String segName){
		this.segName = segName;
	}
	
	public LightCatRequest getRequest() {
		return request;
	}

	public void setRequest(LightCatRequest request) {
		this.request = request;
	}
	
	/**
	 * @return the response
	 */
	public LightCatResponse getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(LightCatResponse response) {
		this.response = response;
	}

	/**
	 * @return the segName
	 */
	public String getSegName() {
		return segName;
	}

	/**
	 * @param segName the segName to set
	 */
	public void setSegName(String segName) {
		this.segName = segName;
	}

	/**
	 * @return the next
	 */
	public UrlLinkNode getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(UrlLinkNode next) {
		this.next = next;
	}
	
}
