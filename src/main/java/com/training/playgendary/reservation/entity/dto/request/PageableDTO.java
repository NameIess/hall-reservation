package com.training.playgendary.reservation.entity.dto.request;

import java.io.Serializable;

public class PageableDTO implements Serializable {
    private int pageSize;
    private int pageNumber;

    public PageableDTO() {
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PageableDTO)) return false;

        PageableDTO that = (PageableDTO) o;

        if (pageSize != that.pageSize) return false;
        return pageNumber == that.pageNumber;
    }

    @Override
    public int hashCode() {
        int result = pageSize;
        result = 31 * result + pageNumber;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PageableDTO{");
        sb.append("pageSize=").append(pageSize);
        sb.append(", pageNumber=").append(pageNumber);
        sb.append('}');
        return sb.toString();
    }
}
