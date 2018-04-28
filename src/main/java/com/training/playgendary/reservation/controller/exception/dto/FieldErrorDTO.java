package com.training.playgendary.reservation.controller.exception.dto;

import java.io.Serializable;

/**
 * Data-transfer object for the transporting validation error details.
 */
public class FieldErrorDTO implements Serializable {
    private String field;
    private String message;

    public FieldErrorDTO() {
    }

    public FieldErrorDTO(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof FieldErrorDTO)) {
            return false;
        }

        FieldErrorDTO that = (FieldErrorDTO) o;

        if (field != null ? !field.equals(that.field) : that.field != null) {
            return false;
        }

        return message != null ? message.equals(that.message) : that.message == null;
    }

    @Override
    public int hashCode() {
        int result = field != null ? field.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FieldErrorDTO{");
        sb.append("field='").append(field).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
