package com.nd.common;

public class PageUtil {
	private int pageSize=2;//每页条数
	private int currentPage;//页号
	private int totalSize;//总条数
	private int totalPage;//总页数
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalSize) {
		if(totalSize%this.pageSize==0) {
			this.totalPage=totalSize/this.pageSize;
		}
		else {
			this.totalPage=(totalSize/this.pageSize)+1;
		}
	}
	
}
