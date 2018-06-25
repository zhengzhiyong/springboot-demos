package com.sby.model;

/**
 * Created by zheng on 2018/6/21.
 */
public class PageRespModel extends RespModel {
    /**
     * 记录总数
     */
    private int total;
    private int currentPage = 0;

    public PageRespModel() {
    }

    public PageRespModel(int code, String desc) {
        super(code, desc);
    }

    public PageRespModel(int code, String desc, Object rows) {
        super(code, desc, rows);
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
