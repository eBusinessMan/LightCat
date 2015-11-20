package com.lightcat.response;

import java.util.ArrayList;

/**
 * 封装了常见的content-type
 * @author LuoZhixiao
 * 
 * content-type待补充，暂时预置常见的
 *
 */
public class HttpContentType {
	private static ArrayList<String> contentTypeList = new ArrayList<String>();
	static{
		contentTypeList.add("text/js");
		contentTypeList.add("text/html");
		contentTypeList.add("text/css");
		contentTypeList.add("text/xml");
		contentTypeList.add("text/plain");
		/*
		 * 后续通过程序添加......
		 */
	}
	
	/**检验静态资源所属的content-type
	 * @param postfix
	 * @return
	 */
	public static String checkContentType(String postfix){
		for(String type : contentTypeList){
			if(type.contains(postfix)){
				return type;
			}
		}
		return "text/plain";//默认
	}
	
}
