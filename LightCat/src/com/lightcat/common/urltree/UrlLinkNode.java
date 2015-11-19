package com.lightcat.common.urltree;

import com.lightcat.request.impl.LightCatRequest;
import com.lightcat.response.impl.LightCatResponse;

/**
 * request对象请求的URI的路径segment节点，LightCat会将之合成url单链表
 * @author LuoZhixiao
 *
 */
public class UrlLinkNode{
	private String segName ;//格式：/urlSegment,如：/user
	private UrlLinkNode next ;//下一个url segment
	
	private LightCatRequest request;//链表上每个node都指向本次请求对象，以在过滤时可以处理request对象
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
