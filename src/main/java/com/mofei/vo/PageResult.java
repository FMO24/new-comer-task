package com.mofei.vo;

import java.util.Collections;
import java.util.List;

public class PageResult {

    private Integer counts;  // 总数
    private Integer page;   // 当前页
    private Integer size;   // 页大小
    private List<?> items = Collections.emptyList();

    public PageResult() {
    }

    public PageResult(Integer counts, Integer page, Integer size, List<?> items) {
        this.counts = counts;
        this.page = page;
        this.size = size;
        this.items = items;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<?> getItems() {
        return items;
    }

    public void setItems(List<?> items) {
        this.items = items;
    }
}
