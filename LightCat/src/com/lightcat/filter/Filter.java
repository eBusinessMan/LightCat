package com.lightcat.filter;

import com.lightcat.request.impl.LightCatRequest;
import com.lightcat.response.impl.LightCatResponse;

/**¹ýÂËÆ÷½Ó¿Ú
 * @author LuoZhixiao
 *
 */
public interface Filter {
	public void doFilter(LightCatRequest request , LightCatResponse response , Filter filterChain);
}
