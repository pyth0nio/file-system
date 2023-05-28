package com.common;

import com.github.pagehelper.Page;
import lombok.Data;

import java.util.List;

/**
 * @author:
 * @date: 2023-04-13
 */
@Data
public class PageInfo {
    /**
     * 页码
     */
    private int page;
    /**
     * 每页条数
     */
    private int limit;

    /**
     *  总数据条数
     */
    private long total;

    /**
     *  总页数
     */
    private int pages;

    /**
     * 数据
     */
    private List data;

    public PageInfo(Page page) {
        this.page = page.getPageNum();
        this.limit = page.getPageSize();
        this.total = page.getTotal();
        this.pages = page.getPages();
        this.data = page.getResult();
    }
}
