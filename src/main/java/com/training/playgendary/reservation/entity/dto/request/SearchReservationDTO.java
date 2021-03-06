package com.training.playgendary.reservation.entity.dto.request;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Data-transfer object for the transporting following entities details: Employee, Reservation.
 */
public class SearchReservationDTO implements Serializable {
    @NotNull
    private Long employeeId;

    @NotNull(message = "error.reservation.DateTimeFormat")
    @DateTimeFormat(pattern = "reservation.dateTimeFormat")
    private Date startTime;

    @NotNull(message = "error.reservation.DateTimeFormat")
    @DateTimeFormat(pattern = "reservation.dateTimeFormat")
    private Date endTime;


    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof SearchReservationDTO)) {
            return false;
        }

        SearchReservationDTO that = (SearchReservationDTO) o;

        if (getEmployeeId() != null ? !getEmployeeId().equals(that.getEmployeeId()) : that.getEmployeeId() != null) {
            return false;
        }

        if (getStartTime() != null ? !getStartTime().equals(that.getStartTime()) : that.getStartTime() != null) {
            return false;
        }

        return getEndTime() != null ? getEndTime().equals(that.getEndTime()) : that.getEndTime() == null;
    }

    @Override
    public int hashCode() {
        int result = getEmployeeId() != null ? getEmployeeId().hashCode() : 0;
        result = 31 * result + (getStartTime() != null ? getStartTime().hashCode() : 0);
        result = 31 * result + (getEndTime() != null ? getEndTime().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SearchReservationDTO{");
        sb.append("employeeId=").append(employeeId);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append('}');
        return sb.toString();
    }
}
