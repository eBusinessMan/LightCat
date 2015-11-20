package com.lightcat.listener;

/**
 * 各级scope的生命周期监听
 * @author LuoZhixiao
 *
 */
public interface ScopeLifecycleListener {
	public void scopeCreated();
	public void scopeDestroyed();
}
