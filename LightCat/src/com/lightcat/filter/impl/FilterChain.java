package com.lightcat.filter.impl;

import java.util.ArrayList;

import com.lightcat.filter.Filter;
import com.lightcat.request.impl.LightCatRequest;
import com.lightcat.response.impl.LightCatResponse;

/**
 * ��������
 * @author LuoZhixiao
 */
public class FilterChain implements Filter {
	private ArrayList<Filter> filterList ;
	private int filterIndex ;//��¼��ǰ�Ĺ��˵�filter����
	@Override
	public void doFilter(LightCatRequest request, LightCatResponse response,
			Filter filterChain) {
		// TODO Auto-generated method stub
		if(filterList == null || filterList.size() == 0 || filterIndex == filterList.size()){
			return ;
		}
		filterList.get(filterIndex++).doFilter(request, response, filterChain);//ע��filterIndex��1
	}
	
	public void addFilter(Filter filter){
		if(filterList == null){
			filterList = new ArrayList<Filter>(5);//���ڹ���������̫�࣬����Ԥ��5
		}
		filterList.add(filter);
	}

}
