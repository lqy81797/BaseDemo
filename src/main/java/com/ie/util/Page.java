/**
 * 
 */
package com.ie.util;

/**
 * @author 
 * @Description: 该类的功能描述
 * @date: 2018年6月4日 下午8:08:35 
 */
public class Page {

	private int showCount; //每页显示记录数
	private int totalPage; //总页数
	private int totalResult; //总记录数
	private int currentPage; //当前页
	private int currentResult; //当前记录起始索引
	private boolean entityOrField; //true:需要分页的地方，传入的参数就是Page实体；false:需要分页的地方，传入的参数所代表的实体拥有Page属性
	private PageData pd = new PageData();

	public Page() {
		
	}
	public int getTotalPage() {
		if (totalResult % showCount == 0)
			totalPage = totalResult / showCount;
		else
			totalPage = totalResult / showCount + 1;
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}

	public int getCurrentPage() {
		if (currentPage <= 0)
			currentPage = 1;
		if (currentPage > getTotalPage())
			currentPage = getTotalPage();
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getShowCount() {
		return showCount;
	}

	public void setShowCount(int showCount) {

		this.showCount = showCount;
	}

	public int getCurrentResult() {
		currentResult = (getCurrentPage() - 1) * getShowCount();
		if (currentResult < 0)
			currentResult = 0;
		return currentResult;
	}

	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}

	public boolean isEntityOrField() {
		return entityOrField;
	}

	public void setEntityOrField(boolean entityOrField) {
		this.entityOrField = entityOrField;
	}

	public PageData getPd() {
		return pd;
	}

	public void setPd(PageData pd) {
		this.pd = pd;
		//设置每页显示条数
		try {
			this.showCount = this.pd.get("pagesize")!=null?Integer.valueOf(this.pd.getString("pagesize")):15;
		} catch (Exception e) {
			this.showCount = this.pd.get("pagesize")!=null?Integer.valueOf(this.pd.getString("pagesize")):15;
		}
		//设置当前页
		if(this.pd.get("page")!=null){
			setCurrentPage(Integer.valueOf(this.pd.getString("page")));
		}
	}

}
