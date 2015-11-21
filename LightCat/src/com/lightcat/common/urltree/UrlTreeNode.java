package com.lightcat.common.urltree;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.lightcat.action.Action;
import com.lightcat.filter.impl.FilterChain;

public class UrlTreeNode {
	private FilterChain pre_FilterChain ;//������봦��
	private FilterChain post_FilterChain ;//��Ӧ����
	private String segName ;//��ʽ��/urlSegment,�磺/user
	private List<UrlTreeNode> subUrlTreeNodeList ;//���url��
	private Action action ; //������
	
	public boolean matchUrlSegment(UrlLinkNode urlLinkNode){
		return this.getSegName().equals(urlLinkNode.getSegName());
	}
	
	/**
	 * �ݹ�ƥ�䲢����url
	 * @param urlLinkNode
	 */
	public boolean handle(UrlLinkNode urlLinkNode) throws IOException{
		if(!urlLinkNode.getRequest().isHasHandle() && matchUrlSegment(urlLinkNode)){//�����url�ڵ�ƥ��
			//�˽ڵ����
			this.pre_FilterChain.doFilter(urlLinkNode.getRequest(), urlLinkNode.getResponse(), this.pre_FilterChain);
			
			//�����ݹ�
			if(urlLinkNode.getNext() != null){
				for(UrlTreeNode subUrlTreeNode : subUrlTreeNodeList){//url�ݹ鴦��
					if(subUrlTreeNode.handle(urlLinkNode.getNext())){
						break;
					}
				}
			}else{
				File targetFile = new File(""+urlLinkNode.getRequest().getContextPath()+File.separator+urlLinkNode.getRequest().getRequestURI());
				if(targetFile.exists()){//����Ǿ�����ļ�����js��css,html��...
					urlLinkNode.getResponse().write(targetFile);
				}else{//�����Action
					this.getAction().handle(urlLinkNode.getRequest() , urlLinkNode.getResponse());
				}
			}
			
			//�˽ڵ����
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
