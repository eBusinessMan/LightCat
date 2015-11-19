package com.lightcat.common.interfaces;

import com.lightcat.request.impl.LightCatRequest;
import com.lightcat.response.impl.LightCatResponse;

public interface Handler {
	public void handle(LightCatRequest request, LightCatResponse response);
}
