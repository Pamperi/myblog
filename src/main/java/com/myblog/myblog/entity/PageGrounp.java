package com.myblog.myblog.entity;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @param <T>
 */
public class PageGrounp<T> implements Serializable {
    private Integer totalPages;//当前页
    private Integer pageSize;//总页数
    private Integer totalElements;//总记录数
    private Integer size;//每页记录数
    private List<T> list;


    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
