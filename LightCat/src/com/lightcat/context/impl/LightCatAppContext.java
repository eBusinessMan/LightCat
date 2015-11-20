package com.lightcat.context.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import com.lightcat.action.Action;
import com.lightcat.common.urltree.UrlLinkNode;
import com.lightcat.common.urltree.UrlTreeNode;
import com.lightcat.context.AppContext;
import com.lightcat.host.Host;
import com.lightcat.listener.event.impl.AttributeEvent;
import com.lightcat.listener.impl.AppContextAttributeListener;
import com.lightcat.listener.impl.AppContextLifecycleListener;
import com.lightcat.request.impl.LightCatRequest;
import com.lightcat.response.impl.LightCatResponse;

/**
 * �����Ų�����host�µĿ����ߵ�webapp
 * @author LuoZhixiao
 * 
 * һ���뷨�����ڻ�����ע���scope�ĸ��ּ������Ĵ����������
 */
public class LightCatAppContext implements AppContext {
	final Host parentHost;
	private String ContextName;// ���webӦ�õ�����

	private UrlTreeNode urlTree_root;// url���ĸ�
										// ���˸���segName�ǡ�/��context���֡������ԡ�/��context���֡���ʼ

	private String file404 ;//404ҳ�棬�������ļ��ж�ȡ������û������õĻ�
	private String fileError ; //errorҳ�棬�������ļ��ж�ȡ������û������õĻ�
	private ArrayList<String> fileWelcome ;//��ӭҳ��:
	
	private AppContextLifecycleListener lifecycleListener ;
	private AppContextAttributeListener attributeListener ;
	
	/**
	 * ��װ�˱�appcontext��Ӧ�������ļ�
	 * ������......
	 */
	private String DOM ;
	
	private HashMap<String , Object> attributeMap = new HashMap<String , Object>(); 
	
	public LightCatAppContext(Host parentHost) {
		this.parentHost = parentHost;
	}

	/**
	 * ��������
	 * 
	 * @param request
	 * @param response
	 */
	@Override
	public void handle(LightCatRequest request, LightCatResponse response) {
		// TODO Auto-generated method stub
		UrlLinkNode urlLinkNode_root = createRequestUrlLink(request);
		// ��ʼƥ��·��������
		urlTree_root.handle(urlLinkNode_root);

		// �������uri�Ѿ������������Ȼû�д���
		if (!request.isHasHandle()) {
			response.return404(new File(file404));
		}
	}

	public UrlLinkNode createRequestUrlLink(LightCatRequest request) {
		String requestUri = request.getRequestURI();
		String[] uriArray = requestUri.split("/");// �ָ�

		UrlLinkNode urlLinkNode_root = new UrlLinkNode("/" + uriArray[1]);// ����0�ǿգ�����������1���Ǳ�context�����֣���Ϊ��
		UrlLinkNode urlLinkNode_last = urlLinkNode_root;// ��ǰ��������һ������ʼ��ʱָ��ͷ�ڵ�
		for (int i = 2; i < uriArray.length; i++) {// ������2 ��ʼ ѭ����������
			UrlLinkNode urlLinkNode_temp = new UrlLinkNode("/" + uriArray[i]);
			urlLinkNode_last.setNext(urlLinkNode_temp);
			urlLinkNode_last = urlLinkNode_temp;
		}

		return urlLinkNode_root;
	}

	/**
	 * @return the urlTree_root
	 */
	public UrlTreeNode getUrlTree_root() {
		return urlTree_root;
	}

	/**
	 * @param urlTree_root
	 *            the urlTree_root to set
	 */
	public void setUrlTree_root(UrlTreeNode urlTree_root) {
		this.urlTree_root = urlTree_root;
	}

	public String getContextName() {
		return ContextName;
	}

	public void setContextName(String contextName) {
		ContextName = contextName;
	}

	public ArrayList<String> getFileWelcome() {
		return fileWelcome;
	}

	public void setFileWelcome(ArrayList<String> fileWelcome) {
		this.fileWelcome = fileWelcome;
	}
	
	/**
	 * ע������״̬������
	 * @param attributeListener
	 */
	public void registerAttributeListener(AppContextAttributeListener attributeListener){
		this.attributeListener = attributeListener;
	}
	/**ע���������ڼ�����
	 * @param lifecycleListener
	 */
	public void registerLifecycleListener(AppContextLifecycleListener lifecycleListener){
		this.lifecycleListener = lifecycleListener;
		this.lifecycleListener.scopeCreated();//һ��ע��͵�ִ�д˷�����
	}

	@Override
	public Enumeration getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttribute(String s, Object obj) {
		// TODO Auto-generated method stub
		if(attributeMap.get(s) != null){//�޸�����
			this.attributeListener.attributeModified(new AttributeEvent(this,s,obj));
		}else{//���������
			if(this.attributeListener != null){
				this.attributeListener.attributeAdded(new AttributeEvent(this,s,obj));
			}
		}
		this.attributeMap.put(s, obj);
	}

	@Override
	public Object getAttribute(String s) {
		// TODO Auto-generated method stub
		return this.attributeMap.get(s);
	}

	@Override
	public void removeAttribute(String s) {
		// TODO Auto-generated method stub
		if(this.attributeListener != null){
			this.attributeListener.attributeRemoved(new AttributeEvent(this,s,null));
		}
		this.attributeMap.remove(s);
	}

	@Override
	public String getRealPath() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
