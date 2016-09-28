package org.agile4j.common.utils.page;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 分页对象
 * 
 * @author hanyx
 *
 */
public class Page<T> implements Serializable {

	private int rowCount = 10;	// 显示行数
	private int totalPage;		// 总页数
	private int totalCount;		// 总数
	private int start;
	private int nowPage;		// 当前页数
	private List<T> result = Collections.emptyList();

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getTotalPage() {
		return (int) Math.ceil(totalCount * 1.0 / rowCount);
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getStart() {
		start = (getNowPage() - 1) * getRowCount();
		if (start < 0) {
			start = 0;
		}
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getNowPage() {
		if (nowPage <= 0) {
			nowPage = 1;
		}
		if (nowPage > getTotalPage()) {
			nowPage = getTotalPage();
		}
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Page [pageShow=" + rowCount + ", totalPage=" + totalPage + ", totalCount=" + totalCount + ", start=" + start + ", nowPage=" + nowPage + ", result=" + result + "]";
	}

}
