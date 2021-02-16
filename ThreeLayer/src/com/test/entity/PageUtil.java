package com.test.entity;

import java.util.List;

public class PageUtil {
	//总页数
	private int totalPageCount=0;
	//页面大小
	private int pageSize=0;
	//记录总数
	private int totalPage=0;
	//当前页码
	private int currPageNo=1;
	//每页集合
	private List<User> users;
	/**
	 * @return the totalPageCount
	 */
	public int getTotalPageCounts() {
		return totalPageCount/pageSize;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	/**
	 * @param totalPageCount the totalPageCount to set
	 */
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		if(pageSize>0)
		this.pageSize = pageSize;
	}
	/**
	 * @return the totalCount
	 */
	public int getTotalPage() {
		return totalPage;
	}
	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		if(totalPage>0) {
			this.totalPage = totalPage;
			//计算页数
			totalPageCount = this.totalPage%pageSize==0?
					(this.totalPage/pageSize):this.totalPage/pageSize+1;
		}
	}
	/**
	 * @return the currPageNo
	 */
	public int getCurrPageNo() {
		if(totalPageCount==0) {
			return 0;
		}else if(currPageNo>totalPageCount) {
			currPageNo=totalPageCount;
		}
		return currPageNo;
	}
	/**
	 * @param currPageNo the currPageNo to set
	 */
	public void setCurrPageNo(int currPageNo) {
		if(this.currPageNo>0)
		this.currPageNo = currPageNo;
	}
	/**
	 * @return the users
	 */
	public List<User> getusers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setusers(List<User> users) {
		this.users = users;
	}
	
	public PageUtil() {
		super();
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Page [totalPageCount=" + totalPageCount + ", pageSize=" + pageSize + ", totalPage=" + totalPage
				+ ", currPageNo=" + currPageNo + ", users=" + users + "]";
	}
	
}
