package com.recorded.common.base;

import org.springframework.stereotype.Component;

import com.recorded.common.constants.Constants;

@Component
public class BaseVo {

    // Paging
    private Integer thisPage = 1; // 현재 페이지
    private Integer rowNumToShow = Constants.ROW_NUM_TO_SHOW; // 화면에 보여줄 데이터 줄 갯수
    private Integer pageNumToShow = Constants.PAGE_NUM_TO_SHOW; // 화면에 보여줄 페이징 번호 갯수

    private Integer totalRows; // 전체 데이터 갯수
    private Integer totalPages; // 전체 페이지 번호
    private Integer startPage; // 시작 페이지 번호
    private Integer endPage; // 마지막 페이지 번호

    private Integer startRnumForOracle = 1; // 쿼리 시작 row
    private Integer endRnumForOracle; // 쿼리 끝 row
    private Integer RNUM;

    private Integer startRnumForMysql = 0; // 쿼리 시작 row

    private Integer start; // 페이지네이션 시작 인덱스
    private Integer pageSize; // 페이지 크기

    // Getter, setter

    public int getThisPage() {
        return thisPage;
    }

    public void setThisPage(Integer thisPage) {
        this.thisPage = thisPage;
    }

    public Integer getRowNumToShow() {
        return rowNumToShow;
    }

    public void setRowNumToShow(Integer rowNumToShow) {
        this.rowNumToShow = rowNumToShow;
    }

    public Integer getPageNumToShow() {
        return pageNumToShow;
    }

    public void setPageNumToShow(Integer pageNumToShow) {
        this.pageNumToShow = pageNumToShow;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getStartPage() {
        return startPage;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    public Integer getEndPage() {
        return endPage;
    }

    public void setEndPage(Integer endPage) {
        this.endPage = endPage;
    }

    public Integer getStartRnumForOracle() {
        return startRnumForOracle;
    }

    public void setStartRnumForOracle(Integer startRnumForOracle) {
        this.startRnumForOracle = startRnumForOracle;
    }

    public Integer getEndRnumForOracle() {
        return endRnumForOracle;
    }

    public void setEndRnumForOracle(Integer endRnumForOracle) {
        this.endRnumForOracle = endRnumForOracle;
    }

    public Integer getRNUM() {
        return RNUM;
    }

    public void setRNUM(Integer rNUM) {
        RNUM = rNUM;
    }

    public int getStartRnumForMysql() {
        return startRnumForMysql;
    }

    public void setStartRnumForMysql(Integer startRnumForMysql) {
        this.startRnumForMysql = startRnumForMysql;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    // Paging calculation
    public void setParamsPaging(Integer totalRows) {

        // Total number of data rows
        setTotalRows(totalRows);

        if (getTotalRows() == 0) {
            setTotalPages(1);
        } else {
            setTotalPages(getTotalRows() / getRowNumToShow());
        }

        if (getTotalRows() % getRowNumToShow() > 0) {
            setTotalPages(getTotalPages() + 1);
        }

        if (getTotalPages() < getThisPage()) {
            setThisPage(getTotalPages());
        }

        // Start page number
        setStartPage(((getThisPage() - 1) / getPageNumToShow()) * getPageNumToShow() + 1);

        // End page number
        setEndPage(getStartPage() + getPageNumToShow() - 1);

        if (getEndPage() > getTotalPages()) {
            setEndPage(getTotalPages());
        }

        // For Oracle
        setEndRnumForOracle((getRowNumToShow() * getThisPage()));

        setStartRnumForOracle((getEndRnumForOracle() - getRowNumToShow()) + 1);
        if (getStartRnumForOracle() < 1)
            setStartRnumForOracle(1);

        // For MySQL
        if (thisPage == 1) {
            setStartRnumForMysql(0);
        } else {
            setStartRnumForMysql((getRowNumToShow() * (getThisPage() - 1)));
        }

        System.out.println("getThisPage():" + getThisPage());
        System.out.println("getTotalRows():" + getTotalRows());
        System.out.println("getRowNumToShow():" + getRowNumToShow());
        System.out.println("getTotalPages():" + getTotalPages());
        System.out.println("getStartPage():" + getStartPage());
        System.out.println("getEndPage():" + getEndPage());
        System.out.println("getStartRnumForOracle():" + getStartRnumForOracle());
        System.out.println("getEndRnumForOracle():" + getEndRnumForOracle());
        System.out.println("getStartRnumForMysql(): " + getStartRnumForMysql());

        System.out.println("------------------------");
        System.out.println("thisPage():" + thisPage);
    }
}
