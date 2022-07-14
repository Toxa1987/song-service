package com.epam.esm.songservice.exception;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity<ApiExceptionResponse> getConstraintViolationException(ConstraintViolationException exception) {
        return new ResponseEntity<>(getResponseEntity(exception), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = {BindException.class})
    public ResponseEntity<ApiExceptionResponse> getBindException(BindException exception) {
        return new ResponseEntity<>(getResponseEntity(exception), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<ApiExceptionResponse> getResourceNotFoundException(ResourceNotFoundException exception) {
        return new ResponseEntity<>(getResponseEntity(exception), HttpStatus.NOT_FOUND);
    }

    private ApiExceptionResponse getResponseEntity(Exception exception) {
        return ApiExceptionResponse.builder()
                .exception(exception.getClass().getName())
                .message(exception.getMessage())
                .build();
    }
}
