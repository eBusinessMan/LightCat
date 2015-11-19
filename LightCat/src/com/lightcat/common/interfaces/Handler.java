package com.lightcat.common.interfaces;

import com.lightcat.request.impl.LightCatRequest;
import com.lightcat.response.impl.LightCatResponse;

/**
 * 处理器接口：lightcat各处理环节
 * @author LuoZhixiao
 *
 */
public interface Handler {
	public void handle(LightCatRequest request, LightCatResponse response);
}
