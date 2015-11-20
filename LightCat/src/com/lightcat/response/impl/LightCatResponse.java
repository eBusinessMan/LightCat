package com.lightcat.response.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import com.lightcat.cookie.Cookie;
import com.lightcat.response.HttpContentType;
import com.lightcat.response.HttpResponse;

/**
 * 响应对象
 * @author LuoZhixiao
 *
 */
public class LightCatResponse implements HttpResponse {
	private OutputStream os;

	private boolean hasSentHeader = false ;
	//响应头集合
	private HashMap<String , String> responseHeaderMap = null ;
	//预定义 响应行
	private String protocol = "HTTP/1.1";
	private String statusCode = "404";
	private String statusDes = "Not Found";
	
	public LightCatResponse(){
		constructOriginHeader();//初始化响应头
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
		 * 还有好多，以后再通过程序批量增加
		 * ......
		 */
		return responseHeaderMap0 ;
	} 
	
	/**
	 * 当请求不存在时
	 */
	public void return404(File file404) {
		try {
			if (file404.exists()) {//当此context中有设置404页面:
				
				//告诉客户端响应头后面是有响应正文的
				this.setHeader("Content-Type", "text/html");
				this.setHeader("Content-Length", ""+file404.length());
				this.os.write(this.constructResponseHeaderText().getBytes());//将响应头都先发送
				
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file404));
				byte[] temp = new byte[1024];
				int length = 0 ;
				
				while((length = bis.read(temp))!=-1){//发送给客户端
					
					this.os.write(temp , 0 , length);
				}
				
				return;
			}
			
			//当此context中没有设置404页面:
			//默认没有响应正文
			this.os.write(this.constructResponseHeaderText().getBytes());//仅仅将响应头发送
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 构造响应头:返回此reponse对象中的所有有效的响应头，而且已经包括 空行 了！
	 */
	public String constructResponseHeaderText() {
		return this.toString() + "\r\n";//添加空行
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
	 * 将请求文件发送给客户端:当访问静态资源时
	 * @throws IOException 
	 */
	public void write(File targetFile) throws IOException {
		// TODO Auto-generated method stub
		String fileName = targetFile.getName();
		String postfix = fileName.substring(fileName.lastIndexOf('.'));
		this.setHeader("Content-Type", HttpContentType.checkContentType(postfix));
		this.setHeader("Content-Length", ""+targetFile.length());
		this.getOutputStream().write(this.toString().getBytes());
		
		FileInputStream fis = new FileInputStream(targetFile); 
		int len = 0;
		byte[] temp = new byte[1024];
		while((len = fis.read(temp))!= -1){
			this.getOutputStream().write(temp , 0 ,len);
		}
	}
	
	/**用于用户断断嘘嘘输出文本
	 * @param source
	 * @throws IOException
	 */
	public void write(byte[] source) throws IOException{
		if(!this.hasSentHeader){
			this.getOutputStream().write(this.toString().getBytes());
		}
		this.getOutputStream().write(source);
	}
}
