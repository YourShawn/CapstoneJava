package com.capstone.healthcare.common.modules;


import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

public class PageListResult<T> implements Serializable {

	/**
	 * 数据列表
	 */
	private List<T> list;

	/**
	 * 页码
	 */
	private Integer pageNum;

	/**
	 * 分页大小
	 */
	private Integer pageSize;

	/**
	 * 记录总数
	 */
	private Long total;

	public PageListResult() {
	}

	public PageListResult(List<T> list, Integer pageNum, Integer pageSize, Long total) {
		this.list = list;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.total = total;
	}

	public PageListResult(List<T> list, Long total) {
		this.list = list;
		this.total = total;
	}

	public PageListResult(List<T> list) {
		if (list == null) {
			this.list = Lists.newArrayList();
		} else {
			this.list = list;
		}
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return new StringBuilder("PageListResult(pageSize=").append(pageSize)
				.append(", pageNum=").append(pageNum)
				.append(", pageSize=").append(pageSize)
				.append(", total=").append(total)
				.append(", listSize=").append(list == null ? "null" : list.size())
				.append(")").toString();
	}
}
