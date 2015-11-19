package com.lightcat.engine;

import com.lightcat.common.interfaces.Handler;
import com.lightcat.request.impl.LightCatRequest;

public interface Engine extends Handler{

	boolean lookForHost(LightCatRequest request);

}
