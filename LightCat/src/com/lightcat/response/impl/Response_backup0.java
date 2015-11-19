package com.lightcat.response.impl;

import java.io.OutputStream;

public class Response_backup0 {
	private OutputStream blockOut ;

	//http响应报文
	private String version ;
	private String statusCode ;
	private String statusDescription ;
	private String ContentType ;
	private byte[] responseEntity ;//传输的实体信息  
	
	public Response_backup0(OutputStream out) {
		// TODO Auto-generated constructor stub
		this.blockOut = out;
	}

	public OutputStream getBlockOut() {
		return blockOut;
	}

	public void setBlockOut(OutputStream blockOut) {
		this.blockOut = blockOut;
	}

}
