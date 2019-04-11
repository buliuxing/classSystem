package com.system.entity;

/**
 * @author ：yangzengrui
 * @date ：Created in 9/4/2019 11:19 PM
 * @description：分页信息类
 */

public class PagingVO {

    //当前页码，默认第一页
    private int curentPageNo = 1;
    //总页数
    private int totalCount;
    //页数容量
    private int pageSize = 5;
    //上一页
    private int upPageNo;
    //下一页
    private int nextPageNo;
    //要前往的页码，默认0
    private int toPageNo = 0;

    public int getCurentPageNo() {
        return curentPageNo;
    }

    public void setCurentPageNo(int curentPageNo) {
        if(curentPageNo != 1){
            this.curentPageNo = curentPageNo - 1;
        }
        this.nextPageNo = curentPageNo + 1;
        this.curentPageNo = curentPageNo;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if(totalCount % pageSize > 0){
            this.totalCount = (totalCount / pageSize) + 1;
        }else {
            this.totalCount = (totalCount / pageSize);
        }

    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getUpPageNo() {
        return upPageNo;
    }

    public void setUpPageNo(int upPageNo) {
        this.upPageNo = upPageNo;
    }

    public int getNextPageNo() {
        return nextPageNo;
    }

    public void setNextPageNo(int nextPageNo) {
        this.nextPageNo = nextPageNo;
    }

    public int getToPageNo() {
        return toPageNo;
    }

    //新的一页
    public void setToPageNo(int toPageNo) {
        this.toPageNo = (toPageNo - 1) * pageSize;
        setCurentPageNo(toPageNo);
    }
}
