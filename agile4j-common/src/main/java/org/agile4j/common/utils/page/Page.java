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

	private int pageShow = 10;
	private int totalPage;
	private int totalCount;
	private int start;
	private int nowPage;
	private List<T> result = Collections.emptyList();

	public int getPageShow() {
		return pageShow;
	}
	public void setPageShow(int pageShow) {
		this.pageShow = pageShow;
	}

	public int getTotalPage() {
		return (int) Math.ceil(totalCount * 1.0 / pageShow);
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
		start = (getNowPage() - 1) * getPageShow();
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
		return "Page [pageShow=" + pageShow + ", totalPage=" + totalPage + ", totalCount=" + totalCount + ", start=" + start + ", nowPage=" + nowPage + ", result=" + result + "]";
	}

}
