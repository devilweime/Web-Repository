package com.b2c.commons.pojo;

import java.util.List;

public class Page {

	private List<?> list;
	private Integer currentPage;
	private Integer totalPage;
	private Integer rows;
	private Integer totalCount;
	// 导航页码数
	private int navigatePages;
	// 所有导航页号
	private int[] navigatepageNums;

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public int[] getNavigatepageNums() {
		return navigatepageNums;
	}

	public void setNavigatepageNums(int[] navigatepageNums) {
		this.navigatepageNums = navigatepageNums;
	}

	public int getNavigatePages() {
		return navigatePages;
	}

	public void setNavigatePages(int navigatePages) {
		this.navigatePages = navigatePages;
		calcNavigatepageNums();
	}

	/**
	 * 计算导航页
	 */
	private void calcNavigatepageNums() {
		// 当总页数小于或等于导航页码数时
		if (totalPage <= navigatePages) {
			navigatepageNums = new int[totalPage];
			for (int i = 0; i < totalPage; i++) {
				navigatepageNums[i] = i + 1;
			}
		} else { // 当总页数大于导航页码数时
			navigatepageNums = new int[navigatePages];
			int startNum = currentPage - navigatePages / 2;
			int endNum = currentPage + navigatePages / 2;

			if (startNum < 1) {
				startNum = 1;
				// (最前navigatePages页
				for (int i = 0; i < navigatePages; i++) {
					navigatepageNums[i] = startNum++;
				}
			} else if (endNum > totalPage) {
				endNum = totalPage;
				// 最后navigatePages页
				for (int i = navigatePages - 1; i >= 0; i--) {
					navigatepageNums[i] = endNum--;
				}
			} else {
				// 所有中间页
				for (int i = 0; i < navigatePages; i++) {
					navigatepageNums[i] = startNum++;
				}
			}
		}
	}
}
