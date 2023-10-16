package com.capstone.healthcare.common.modules;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PageInfo implements Serializable {

	// 页码
	private static final int PAGE_NUMBER = 1;

	// 页面大小
	private static final int PAGE_SIZE = 10;

	/**
	 * 页码
	 */
	private Integer pageNum;

	/**
	 * 分页大小
	 */
	private Integer pageSize;

	private String orderBy;

	/**
	 * 是否需要查询count总数
	 */
	private Boolean isCount = false;

	/**
	 * 记录总数
	 */
	private Integer total;

	public PageInfo() {
		this.pageNum = PAGE_NUMBER;
		this.pageSize = PAGE_SIZE;
	}

	public PageInfo(Integer pageNum, Integer pageSize, Integer total) {
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.total = total;
	}

	public void setPageInfo(Integer pageNum, Integer pageSize) {
		this.pageSize = pageSize;
		this.pageNum = pageNum;
	}

	public int getOffset() {
		if (pageNum == null || pageNum == 0 || pageNum == 1) {
			return 0;
		}
		return (pageNum - 1) * pageSize;
	}

}
