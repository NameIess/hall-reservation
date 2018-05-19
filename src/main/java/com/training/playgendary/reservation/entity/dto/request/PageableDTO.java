package com.training.playgendary.reservation.entity.dto.request;

import java.io.Serializable;

public class PageableDTO implements Serializable {
    private int pageSize;
    private int pageNumber;
    private String sortedField;
    private String sortDirection;

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

    public String getSortedField() {
        return sortedField;
    }

    public void setSortedField(String sortedField) {
        this.sortedField = sortedField;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PageableDTO)) return false;

        PageableDTO that = (PageableDTO) o;

        if (pageSize != that.pageSize) return false;
        if (pageNumber != that.pageNumber) return false;
        if (sortedField != null ? !sortedField.equals(that.sortedField) : that.sortedField != null) return false;
        return sortDirection != null ? sortDirection.equals(that.sortDirection) : that.sortDirection == null;
    }

    @Override
    public int hashCode() {
        int result = pageSize;
        result = 31 * result + pageNumber;
        result = 31 * result + (sortedField != null ? sortedField.hashCode() : 0);
        result = 31 * result + (sortDirection != null ? sortDirection.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PageableDTO{");
        sb.append("pageSize=").append(pageSize);
        sb.append(", pageNumber=").append(pageNumber);
        sb.append(", sortedField='").append(sortedField).append('\'');
        sb.append(", sortDirection='").append(sortDirection).append('\'');
        sb.append('}');
        return sb.toString();
    }
}