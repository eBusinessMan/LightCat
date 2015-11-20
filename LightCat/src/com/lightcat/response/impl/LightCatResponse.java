package com.lightcat.response.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import com.lightcat.cookie.Cookie;
import com.lightcat.response.HttpResponse;

/**
 * ��Ӧ����
 * @author LuoZhixiao
 *
 */
public class LightCatResponse implements HttpResponse {
	private OutputStream os;

	//��Ӧͷ����
	private HashMap<String , String> responseHeaderMap = null ;
	//Ԥ���� ��Ӧ��
	private String protocol = "HTTP/1.1";
	private String statusCode = "404";
	private String statusDes = "Not Found";
	
	public LightCatResponse(){
		constructOriginHeader();//��ʼ����Ӧͷ
	}
	
	public HashMap<String , String> constructOriginHeader(){
		HashMap<String , String> responseHeaderMap0 = new HashMap<String , String>();
		responseHeaderMap0.put("Date", null);
		responseHeaderMap0.put("Content-Type", null);
		responseHeaderMap0.put("Content-Length", null);
		responseHeaderMap0.put("Connection", null);
		responseHeaderMap0.put("Cache-Control", null);
		responseHeaderMap0.put("Expires", null);
		responseHeaderMap0.put("Last-Modified", null);
		/*
		 * ......
		 * ���кö࣬�Ժ���ͨ��������������
		 * ......
		 */
		return responseHeaderMap0 ;
	} 
	
	/**
	 * �����󲻴���ʱ
	 */
	public void return404(File file404) {
		try {
			if (file404.exists()) {//����context��������404ҳ��:
				
				//���߿ͻ�����Ӧͷ����������Ӧ���ĵ�
				this.setHeader("Content-Type", "text/html");
				this.setHeader("Content-Length", ""+file404.length());
				this.os.write(this.constructResponseHeaderText().getBytes());//����Ӧͷ���ȷ���
				
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file404));
				byte[] temp = new byte[1024];
				int length = 0 ;
				
				while((length = bis.read(temp))!=-1){//���͸��ͻ���
					
					this.os.write(temp , 0 , length);
				}
				
				return;
			}
			
			//����context��û������404ҳ��:
			//Ĭ��û����Ӧ����
			this.os.write(this.constructResponseHeaderText().getBytes());//��������Ӧͷ����
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ������Ӧͷ:���ش�reponse�����е�������Ч����Ӧͷ�������Ѿ����� ���� �ˣ�
	 */
	public String constructResponseHeaderText() {
		return this.toString() + "\r\n";//��ӿ���
	}

	@Override
	public String toString() {
		String firtHang = ""+this.getProtocol()+" "+this.getStatusCode()+" "+this.getStatusDes()+"\r\n";
		for(String key : this.responseHeaderMap.keySet()){
			firtHang += key + ":" + this.responseHeaderMap.get(key) + "\r\n";
		}
		return firtHang;		
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return os;
	}

	/**
	 * @param os
	 *            the os to set
	 */
	public void setOs(OutputStream os) {
		this.os = os;
	}
	
	@Override
	public void addCookie(Cookie cookie) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean containsHeader(String s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String encodeURL(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String encodeRedirectURL(String s) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setHeader(String s, String s1) {
		// TODO Auto-generated method stub
		if(s==null || s.equals("")){
			return ;
		}
		this.responseHeaderMap.put(s, s1);
	}

	@Override
	public void addHeader(String s, String s1) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String getHeader(String header) {
		// TODO Auto-generated method stub
		return this.responseHeaderMap.get(header);
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendRedirect(String s) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection getHeaders(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection getHeaderNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDes() {
		return statusDes;
	}

	public void setStatusDes(String statusDes) {
		this.statusDes = statusDes;
	}

	/**
	 * �������ļ����͸��ͻ���
	 */
	public void write(File targetFile) {
		// TODO Auto-generated method stub
		
	}

}
