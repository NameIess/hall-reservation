package com.training.playgendary.reservation.controller.exception;

import com.training.playgendary.reservation.controller.exception.dto.ErrorFormInfo;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Contains method-advice for unified exception handling.
 */
@ControllerAdvice(annotations = RestController.class)
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<ErrorFormInfo> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        ErrorFormInfo errorDto = processFieldErrors(fieldErrors);
        return new ResponseEntity<>(
                errorDto, HttpStatus.BAD_REQUEST);
    }

    private ErrorFormInfo processFieldErrors(List<FieldError> fieldErrors) {
        ErrorFormInfo errorFormInfo = new ErrorFormInfo();

        for (FieldError fieldError : fieldErrors) {
            String message = fieldError.getDefaultMessage();
            String field = fieldError.getField();
            errorFormInfo.addFieldError(field, message);
        }

        return errorFormInfo;
    }
}
