package com.lightcat.filter.impl;

import java.util.ArrayList;

import com.lightcat.filter.Filter;
import com.lightcat.request.impl.LightCatRequest;
import com.lightcat.response.impl.LightCatResponse;

/**
 * 过滤器链
 * @author LuoZhixiao
 */
public class FilterChain implements Filter {
	private ArrayList<Filter> filterList ;
	private int filterIndex ;//记录当前的过滤的filter索引
	@Override
	public void doFilter(LightCatRequest request, LightCatResponse response,
			Filter filterChain) {
		// TODO Auto-generated method stub
		if(filterList == null || filterList.size() == 0 || filterIndex == filterList.size()){
			return ;
		}
		filterList.get(filterIndex++).doFilter(request, response, filterChain);//注意filterIndex加1
	}
	
	public void addFilter(Filter filter){
		if(filterList == null){
			filterList = new ArrayList<Filter>(5);//由于过滤器不会太多，所以预设5
		}
		filterList.add(filter);
	}

}
