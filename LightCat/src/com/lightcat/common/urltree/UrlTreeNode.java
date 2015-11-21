package com.lightcat.common.urltree;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.lightcat.action.Action;
import com.lightcat.filter.impl.FilterChain;

public class UrlTreeNode {
	private FilterChain pre_FilterChain ;//请求进入处理
	private FilterChain post_FilterChain ;//响应后处理
	private String segName ;//格式：/urlSegment,如：/user
	private List<UrlTreeNode> subUrlTreeNodeList ;//后代url树
	private Action action ; //控制器
	
	public boolean matchUrlSegment(UrlLinkNode urlLinkNode){
		return this.getSegName().equals(urlLinkNode.getSegName());
	}
	
	/**
	 * 递归匹配并处理url
	 * @param urlLinkNode
	 */
	public boolean handle(UrlLinkNode urlLinkNode) throws IOException{
		if(!urlLinkNode.getRequest().isHasHandle() && matchUrlSegment(urlLinkNode)){//如果此url节点匹配
			//此节点过滤
			this.pre_FilterChain.doFilter(urlLinkNode.getRequest(), urlLinkNode.getResponse(), this.pre_FilterChain);
			
			//继续递归
			if(urlLinkNode.getNext() != null){
				for(UrlTreeNode subUrlTreeNode : subUrlTreeNodeList){//url递归处理
					if(subUrlTreeNode.handle(urlLinkNode.getNext())){
						break;
					}
				}
			}else{
				File targetFile = new File(""+urlLinkNode.getRequest().getContextPath()+File.separator+urlLinkNode.getRequest().getRequestURI());
				if(targetFile.exists()){//如果是具体的文件：如js，css,html等...
					urlLinkNode.getResponse().write(targetFile);
				}else{//如果是Action
					this.getAction().handle(urlLinkNode.getRequest() , urlLinkNode.getResponse());
				}
			}
			
			//此节点后处理
			this.post_FilterChain.doFilter(urlLinkNode.getRequest(), urlLinkNode.getResponse(), this.post_FilterChain);
			
			return true;
		}
		return false;
	}
	
	public FilterChain getPre_FilterChain() {
		return pre_FilterChain;
	}
	public void setPre_FilterChain(FilterChain pre_FilterChain) {
		this.pre_FilterChain = pre_FilterChain;
	}
	public FilterChain getPost_FilterChain() {
		return post_FilterChain;
	}
	public void setPost_FilterChain(FilterChain post_FilterChain) {
		this.post_FilterChain = post_FilterChain;
	}
	public String getSegName() {
		return segName;
	}
	public void setSegName(String segName) {
		this.segName = segName;
	}
	public List<UrlTreeNode> getSubUrlTreeNode() {
		return subUrlTreeNodeList;
	}
	public void setSubUrlTreeNode(List<UrlTreeNode> subUrlTreeNodeList) {
		this.subUrlTreeNodeList = subUrlTreeNodeList;
	}
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}	
}
