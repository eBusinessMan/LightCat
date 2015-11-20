package com.lightcat.response;

import java.util.ArrayList;

/**
 * ��װ�˳�����content-type
 * @author LuoZhixiao
 * 
 * content-type�����䣬��ʱԤ�ó�����
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
		 * ����ͨ���������......
		 */
	}
	
	/**���龲̬��Դ������content-type
	 * @param postfix
	 * @return
	 */
	public static String checkContentType(String postfix){
		for(String type : contentTypeList){
			if(type.contains(postfix)){
				return type;
			}
		}
		return "text/plain";//Ĭ��
	}
	
}
