package com.Utils;

/**
 * @descrpition: 分页信息类
 * @author: 20155808李连芸
 * @date 2018年4月13日 上午8:39:09
 */

import java.util.List;

/**
 * @className: PageInfo.java
 * @descrpition: TODO
 * @author: 20155808李连芸
 * @date 2018年4月13日 上午8:39:09
 */
public class Page<T> {
    public static int PAGESIZE;
    private Integer count;//总记录数
    private Integer totalPages;//总页数
    private Integer currentPage;//当前页号
    private List<T> pageList;//当前页记录集

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getCount() {
        return count;

    }
    public void setCount(Integer count) {
        this.count = count;
    }
    public Integer getTotalPages() {
        totalPages = count%PAGESIZE == 0 ? count/PAGESIZE:count/PAGESIZE+1;
        return totalPages;
    }
    public List<T> getPageList() {
        return pageList;
    }
    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }
    public int getCurPage(int page) {
        int currentIndex = (page == 0)? 1: page;
        return currentIndex;
    }

}
