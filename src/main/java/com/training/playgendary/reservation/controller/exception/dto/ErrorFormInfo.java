package com.training.playgendary.reservation.controller.exception.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Data-transfer object for containing a list of transfer objects.
 */
public class ErrorFormInfo implements Serializable {

    private List<FieldErrorDTO> fieldErrors = new ArrayList<>();

    public ErrorFormInfo() {
    }

    public void addFieldError(String path, String message) {
        FieldErrorDTO error = new FieldErrorDTO(path, message);
        fieldErrors.add(error);
    }

    public List<FieldErrorDTO> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldErrorDTO> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof ErrorFormInfo)) {
            return false;
        }

        ErrorFormInfo that = (ErrorFormInfo) o;

        return fieldErrors != null ? fieldErrors.equals(that.fieldErrors) : that.fieldErrors == null;
    }

    @Override
    public int hashCode() {
        return fieldErrors != null ? fieldErrors.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ErrorFormInfo{");
        sb.append("fieldErrors=").append(fieldErrors);
        sb.append('}');
        return sb.toString();
    }
}
