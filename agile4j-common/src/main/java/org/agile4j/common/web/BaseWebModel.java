package org.agile4j.common.web;

public class BaseWebModel {
	private String queryJsonStr = "";
	private int nowPage = 1;	// 当前页数
	private int rowCount = 2;	// 显示行数

	public String getQueryJsonStr() {
		return queryJsonStr;
	}

	public void setQueryJsonStr(String queryJsonStr) {
		this.queryJsonStr = queryJsonStr;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	@Override
	public String toString() {
		return "BaseWebModel [queryJsonStr=" + queryJsonStr + ", nowPage=" + nowPage + ", rowCount=" + rowCount + "]";
	}

}
